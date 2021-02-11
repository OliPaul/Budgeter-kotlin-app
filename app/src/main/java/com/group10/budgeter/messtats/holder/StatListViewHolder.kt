package com.group10.budgeter.messtats.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.group10.budgeter.R
import com.group10.budgeter.messtats.MesStats
import com.group10.budgeter.messtats.onStatClicked

class StatListViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.messtat_list_layout,parent,false)),
    View.OnClickListener {

    private var statmoisText: TextView? = null;
    private var statAmountText: TextView? = null;
    private var stat: MesStats? = null;
    private var onStatClicked: onStatClicked? = null;



    init {
        statmoisText = itemView.findViewById(R.id.stat_mois_text);
        statAmountText = itemView.findViewById(R.id.stat_amount_text);
    }

    fun bind(stat: MesStats){
        this.stat = stat;
        this.onStatClicked = onStatClicked

        statmoisText?.text = stat.statmois;
        statAmountText?.text = stat.statAmount.toString() + "€";

       itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        onStatClicked?.onStatClicked(stat);
    }


}


