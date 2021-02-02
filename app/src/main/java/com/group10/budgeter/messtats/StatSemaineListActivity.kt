package com.group10.budgeter.messtats

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.group10.budgeter.R
import com.group10.budgeter.messtats.adapter.StatListAdapter
import kotlinx.android.synthetic.main.activity_spend_list.*
import java.util.*

class StatSemaineListActivity: AppCompatActivity() {
    private val statSemaineList: List<MesStatsSemaine> = listOf(

        MesStatsSemaine("Semaine1",  60.00,Date()),
        MesStatsSemaine("Semaine2",  10.00,Date()),
        MesStatsSemaine("Semaine3",  40.00,Date()),
        MesStatsSemaine("Semaine4",  70.00,Date())
    );

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messtats_semaine_list);
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(this@StatSemaineListActivity);
            adapter = StatListAdapter(statSemaineList, this@StatSemaineListActivity);
        }
    }

}

