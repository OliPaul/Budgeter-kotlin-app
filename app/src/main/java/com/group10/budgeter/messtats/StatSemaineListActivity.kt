package com.group10.budgeter.messtats

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.group10.budgeter.R
import com.group10.budgeter.messtats.adapter.StatSemaineListAdapter
import kotlinx.android.synthetic.main.activity_messtats_semaine_list.*
import kotlinx.android.synthetic.main.activity_spend_list.*
import java.util.*

class StatSemaineListActivity: AppCompatActivity(), View.OnClickListener {
    private val statSemaineList: List<MesStatsSemaine> = listOf(

        MesStatsSemaine("Semaine1",  60.00,Date()),
        MesStatsSemaine("Semaine2",  10.00,Date()),
        MesStatsSemaine("Semaine3",  40.00,Date()),
        MesStatsSemaine("Semaine4",  70.00,Date())
    );

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messtats_semaine_list);
        backToHomestatsemaine.setOnClickListener(this);
        recyclerViewstatsemaine?.apply {
            layoutManager = LinearLayoutManager(this@StatSemaineListActivity);
            adapter = StatSemaineListAdapter(statSemaineList);
        }
    }

    override fun onClick(v: View?) {
        startActivity(Intent(this, StatListActivity::class.java));
    }

}

