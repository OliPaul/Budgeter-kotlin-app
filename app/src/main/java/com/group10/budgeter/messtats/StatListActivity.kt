package com.group10.budgeter.messtats

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.group10.budgeter.MainActivity
import com.group10.budgeter.R
import com.group10.budgeter.accueil.HomeScreenActivity
import com.group10.budgeter.messtats.adapter.StatListAdapter
import com.group10.budgeter.spend.Spend
import com.group10.budgeter.spend.adapter.SpendListAdapter
import kotlinx.android.synthetic.main.activity_messtat_list.*
import kotlinx.android.synthetic.main.activity_spend_list.*
import java.util.*
import kotlin.collections.HashMap

class StatListActivity : AppCompatActivity(), View.OnClickListener {

    private var january: MesStats = MesStats("Janvier", 0.00);
    private var february: MesStats = MesStats("Fevrier", 0.00);
    private var march: MesStats = MesStats("Mars", 0.00);
    private var april: MesStats = MesStats("Avril", 0.00);
    private var may: MesStats = MesStats("Mai", 0.00);
    private var june: MesStats = MesStats("Juin", 0.00);
    private var july: MesStats = MesStats("Juillet", 0.00);
    private var august: MesStats = MesStats("Aout", 0.00);
    private var september: MesStats = MesStats("Septembre", 0.00);
    private var october: MesStats = MesStats("Octobre", 0.00);
    private var november: MesStats = MesStats("Novembre", 0.00);
    private var december: MesStats = MesStats("Décembre", 0.00);
    private var sum: Double = 0.0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messtat_list);
        backToHomestat.setOnClickListener(this);
        getSpendData();
    }

    fun getSpendData() {
        val database = Firebase.database;

        //Get user pseudo
        val sharedPreferences = getSharedPreferences("Budgeter", Context.MODE_PRIVATE);
        val userID = sharedPreferences.getString("userID", null);


        val myRef = database.getReference("spend");
        var spendList: MutableList<Spend> = mutableListOf();

        myRef.orderByChild("userID").equalTo(userID).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue<HashMap<String, Any>>()
                if (value != null) {
                    for (spend in value) {
                        spendList.add(Gson().fromJson(Gson().toJson(spend.value), Spend::class.java));
                    }

                    //Processing monthly report
                    val statList = monthlyReport(spendList);
                    //Update total
                    bilanannuel.setText(sum.toString() + " €");
                    //Generate list
                    recyclerViewStat?.apply {
                        layoutManager = LinearLayoutManager(this@StatListActivity);
                        adapter = StatListAdapter(statList);
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("List Activity", "Failed to read value.", error.toException())
            }
        });
    }
    fun calculMonthlySpend(spend: Spend){
        if (Date(spend.spendDate).month == 0) {
            january.statAmount += spend.spendAmount
            // if(Date(spend.spendDate).day <= 0)
        }
        if (Date(spend.spendDate).month == 1) {
            february.statAmount += spend.spendAmount
        }
        if (Date(spend.spendDate).month == 2) {
            march.statAmount += spend.spendAmount
        }
        if (Date(spend.spendDate).month == 3) {
            april.statAmount += spend.spendAmount
        }
        if (Date(spend.spendDate).month == 4) {
            may.statAmount += spend.spendAmount
        }
        if (Date(spend.spendDate).month == 5) {
            june.statAmount += spend.spendAmount
        }
        if (Date(spend.spendDate).month == 6) {
            july.statAmount += spend.spendAmount
        }
        if (Date(spend.spendDate).month == 7) {
            august.statAmount += spend.spendAmount
        }
        if (Date(spend.spendDate).month == 8) {
            september.statAmount += spend.spendAmount
        }
        if (Date(spend.spendDate).month == 9) {
            october.statAmount += spend.spendAmount
        }
        if (Date(spend.spendDate).month == 10) {
            november.statAmount += spend.spendAmount
        }
        if (Date(spend.spendDate).month == 11) {
            december.statAmount += spend.spendAmount
        }

    }

    fun displayMonth(listMesStats: MutableList<MesStats>): MutableList<MesStats>{
        if(Date().month >= 0){
            listMesStats.add(january)
        }
        if(Date().month >= 1){
            listMesStats.add(february)
        }
        if(Date().month >= 2){
            listMesStats.add(march)
        }
        if(Date().month >= 3){
            listMesStats.add(april)
        }
        if(Date().month >= 4){
            listMesStats.add(may)
        }
        if(Date().month >= 5){
            listMesStats.add(june)
        }
        if(Date().month >= 6){
            listMesStats.add(july)
        }
        if(Date().month >= 7){
            listMesStats.add(august)
        }
        if(Date().month >= 8){
            listMesStats.add(september)
        }
        if(Date().month >= 9){
            listMesStats.add(october)
        }
        if(Date().month >= 10){
            listMesStats.add(november)
        }
        if(Date().month >= 11){
            listMesStats.add(december)
        }

        return listMesStats;
    }



    fun monthlyReport(spendList: MutableList<Spend>): List<MesStats> {
        val statList: MutableList<MesStats> = mutableListOf();
        for (spend in spendList) {

            sum += spend.spendAmount;
            calculMonthlySpend(spend);

        }


        return displayMonth(statList);
    }

    override fun onClick(v: View?) {
        startActivity(Intent(this, HomeScreenActivity::class.java));
    }
}


