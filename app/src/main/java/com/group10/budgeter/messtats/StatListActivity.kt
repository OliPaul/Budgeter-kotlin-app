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

        /*for (spend in spendList){
            var sum: Double = 0.0;
            if(spend.spendDate >= "01/01/2021" && spend.spendDate <= "31/01/2021"){
                sum += spend.spendAmount;
            }
        }*/
        recyclerViewStat?.apply {
            layoutManager = LinearLayoutManager(this@StatListActivity);
            adapter = StatListAdapter(statList, this@StatListActivity);
        }
    }

   override fun onStatClicked(mesStats: MesStats?) {
       startActivity(Intent(this, StatSemaineListActivity::class.java));
   }

    override fun onClick(v: View?) {
        startActivity(Intent(this, MainActivity::class.java));
    }
}


