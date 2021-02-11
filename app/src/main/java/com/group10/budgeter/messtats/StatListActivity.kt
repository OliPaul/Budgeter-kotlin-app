package com.group10.budgeter.messtats

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.group10.budgeter.MainActivity
import com.group10.budgeter.R
import com.group10.budgeter.messtats.adapter.StatListAdapter
import kotlinx.android.synthetic.main.activity_messtat_list.*
import kotlinx.android.synthetic.main.activity_spend_list.*

class StatListActivity: AppCompatActivity(), View.OnClickListener, onStatClicked{

    private val statList: List<MesStats> = listOf(
        MesStats("Janvier", 60.00),
        MesStats("Fevrier", 10.00),
        MesStats("Mars", 20.00),
        MesStats("Avril", 60.00),
        MesStats("Mai", 40.00),
        MesStats("Juin", 60.00),
        MesStats("Juillet", 70.00),
        MesStats("Aout", 90.00),
        MesStats("Septembre", 10.00),
        MesStats("Octobre", 90.00),
        MesStats("Novembre", 60.00),
        MesStats("Décembre", 60.00)
    );

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messtat_list);

        recyclerViewStat?.apply {
            layoutManager = LinearLayoutManager(this@StatListActivity);
            adapter = StatListAdapter(statList, this@StatListActivity);
        }
    }

    fun getSpendData(){
        val database = Firebase.database;
        val myRef = database.getReference("spend");
        var spendList: MutableList<Spend> = mutableListOf();

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue<HashMap<String, Any>>()
                if (value != null) {
                    for (spend in value){
                        spendList.add(Gson().fromJson(spend.value.toString(), Spend::class.java));
                    }
                    //Generate list
                    recyclerView?.apply {
                        layoutManager = LinearLayoutManager(this@SpendListActivity);
                        adapter = SpendListAdapter(spendList, this@SpendListActivity);
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("List Activity", "Failed to read value.", error.toException())
            }
        });
    }

fun bilanMensuelle(spendList) {
    var statList: MutableList<MesStats> = mutableListOf();
    for (MesStats. statList){
        for (spend in spendList) {
            var sum: Double = 0.0;

            if (spend.spendDate >= "01/01/2021" && spend.spendDate <= "31/01/2021") {
                sum += spend.spendAmount;
                MesStats.statAmount = sum;
                //stat_amount_text
            }
            if (spend.spendDate >= "01/02/2021" && spend.spendDate <= "28/02/2021") {
                sum += spend.spendAmount;
                MesStats.statAmount = sum;
            }
            if (spend.spendDate >= "01/03/2021" && spend.spendDate <= "31/03/2021") {
                sum += spend.spendAmount;
                MesStats.statAmount = sum;
            }
            if (spend.spendDate >= "01/04/2021" && spend.spendDate <= "30/04/2021") {
                sum += spend.spendAmount;
                MesStats.statAmount = sum;
            }
            if (spend.spendDate >= "01/05/2021" && spend.spendDate <= "31/05/2021") {
                sum += spend.spendAmount;
                MesStats.statAmount = sum;
            }
            if (spend.spendDate >= "01/06/2021" && spend.spendDate <= "30/06/2021") {
                sum += spend.spendAmount;
                MesStats.statAmount = sum;
            }
            if (spend.spendDate >= "01/07/2021" && spend.spendDate <= "31/07/2021") {
                sum += spend.spendAmount;
                MesStats.statAmount = sum;
            }
            if (spend.spendDate >= "01/08/2021" && spend.spendDate <= "31/08/2021") {
                sum += spend.spendAmount;
                MesStats.statAmount = sum;
            }
            if (spend.spendDate >= "01/09/2021" && spend.spendDate <= "30/09/2021") {
                sum += spend.spendAmount;
                MesStats.statAmount = sum;
            }
            if (spend.spendDate >= "01/10/2021" && spend.spendDate <= "31/10/2021") {
                sum += spend.spendAmount;
                MesStats.statAmount = sum;
            }
            if (spend.spendDate >= "01/11/2021" && spend.spendDate <= "30/11/2021") {
                sum += spend.spendAmount;
                MesStats.statAmount = sum;

            }if (spend.spendDate >= "01/12/2021" && spend.spendDate <= "31/12/2021") {
                sum += spend.spendAmount;
                MesStats.statAmount = sum;
            }
        }
    }
}
   override fun onStatClicked(mesStats: MesStats?) {
       startActivity(Intent(this, StatSemaineListActivity::class.java));
   }

    override fun onClick(v: View?) {
        startActivity(Intent(this, MainActivity::class.java));
    }
}


