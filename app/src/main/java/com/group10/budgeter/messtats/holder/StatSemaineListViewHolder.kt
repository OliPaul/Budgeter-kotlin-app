package com.group10.budgeter.messtats.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.group10.budgeter.R
import com.group10.budgeter.messtats.MesStats
import com.group10.budgeter.messtats.MesStatsSemaine
import com.group10.budgeter.messtats.onStatClicked
import com.group10.budgeter.spend.OnSpendClicked
import com.group10.budgeter.spend.Spend

class StatSemaineListViewHolder(inflater: LayoutInflater,parent: ViewGroup):
RecyclerView.ViewHolder(inflater.inflate(R.layout.messtat_semaine_list_layout,parent,false)){

    private var semaineTitleText: TextView? = null;
    private var statsDateText: TextView? = null;
    private var statsAmountText: TextView? = null;

    init {
        semaineTitleText = itemView.findViewById(R.id.messtatssemaine_title_text);
        statsDateText = itemView.findViewById(R.id.messtatssemaine_date_text);
        statsAmountText = itemView.findViewById(R.id.messtatssemaine_amount_text);
    }

    fun bind(statsemaine: MesStatsSemaine){

        semaineTitleText?.text = statsemaine.semaineTitle;
        statsDateText?.text = statsemaine.statsDate.toString();
        statsAmountText?.text = statsemaine.statsAmount.toString() + "€";

    }


}