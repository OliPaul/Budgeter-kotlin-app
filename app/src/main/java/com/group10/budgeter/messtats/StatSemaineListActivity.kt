package com.group10.budgeter.messtats

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.group10.budgeter.R
import com.group10.budgeter.messtats.adapter.StatSemaineListAdapter
import com.group10.budgeter.spend.Spend
import kotlinx.android.synthetic.main.activity_messtats_semaine_list.*
import kotlinx.android.synthetic.main.activity_spend_list.*
import java.util.*

class StatSemaineListActivity: AppCompatActivity(), View.OnClickListener {
    private val statSemaineList: List<MesStatsSemaine> = listOf(

        MesStatsSemaine("Semaine1",  60.00 , Date()),
        MesStatsSemaine("Semaine2",  10.00 , Date()),
        MesStatsSemaine("Semaine3",  40.00 , Date()),
        MesStatsSemaine("Semaine4",  70.00 , Date())
    );
    private var semaine1: MesStatsSemaine = MesStatsSemaine("Semaine1", 0.00, Date());
    private var semaine2: MesStatsSemaine = MesStatsSemaine("Semaine2", 0.00, Date());
    private var semaine3: MesStatsSemaine= MesStatsSemaine("Semaine3", 0.00, Date());
    private var semaine4: MesStatsSemaine = MesStatsSemaine("Semaine4", 0.00, Date());


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messtats_semaine_list);
        backToHomestatsemaine.setOnClickListener(this);
        recyclerViewstatsemaine?.apply {
            layoutManager = LinearLayoutManager(this@StatSemaineListActivity);
            adapter = StatSemaineListAdapter(statSemaineList);
        }
    }


    fun getSpendData() {
        val database = Firebase.database;
        val myRef = database.getReference("spend");
        var spendList: MutableList<Spend> = mutableListOf();

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue<HashMap<String, Any>>()
                if (value != null) {
                    for (spend in value) {
                        spendList.add(Gson().fromJson(spend.value.toString(), Spend::class.java));
                    }

                    //Processing monthly report
                    val statList = monthlyReport(spendList);
                    //Update total
                    bilanannuel.setText(sum.toString() + " €");
                    //Generate list
                    recyclerViewStat?.apply {
                        layoutManager = LinearLayoutManager(this@StatListActivity);
                        adapter = StatListAdapter(statList, this@StatListActivity);
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("List Activity", "Failed to read value.", error.toException())
            }
        });
    }

    fun weeklyReport(spendList: MutableList<Spend>): List<MesStats> {
        val statList: MutableList<MesStats> = mutableListOf();
        for (spend in spendList) {
            sum += spend.spendAmount;


            if (Date(spend.spendDate).month == 0) {
                semaine1.statsAmount += spend.spendAmount
                if(Date(spend.spendDate).day <= 7) {
                    semaine2.statsAmount += spend.spendAmount
                }
                    if(Date(spend.spendDate).day <= 14){
                        semaine3.statsAmount += spend.spendAmount
                    }
                        if(Date(spend.spendDate).day <= 21){
                            semaine3.statsAmount += spend.spendAmount
                        }
                            if(Date(spend.spendDate).day <= 31){
                                semaine4.statsAmount += spend.spendAmount
                            }
            }


            if (Date(spend.spendDate).month == 1) {
                february.statAmount += spend.spendAmount
                // if(Date(spend.spendDate).day <= 0)
            }
            if (Date(spend.spendDate).month == 2) {
                march.statAmount += spend.spendAmount
                // if(Date(spend.spendDate).day <= 0)
            }
            if (Date(spend.spendDate).month == 3) {
                april.statAmount += spend.spendAmount
                // if(Date(spend.spendDate).day <= 0)
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




    override fun onClick(v: View?) {
        startActivity(Intent(this, StatListActivity::class.java));
    }

}

