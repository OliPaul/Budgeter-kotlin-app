package com.group10.budgeter.messtats.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.group10.budgeter.messtats.MesStats
import com.group10.budgeter.messtats.holder.StatListViewHolder
import com.group10.budgeter.messtats.onStatClicked

class StatListAdapter(
    private val stat: List<MesStats>,
    private val onStatClicked: onStatClicked
) : RecyclerView.Adapter<StatListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatListViewHolder {
        val inflater = LayoutInflater.from(parent.context);
        return StatListViewHolder(inflater, parent);
    }
    override fun onBindViewHolder(holder: StatListViewHolder, position: Int) {
        val stat = stat[position];
        holder.bind(stat, onStatClicked);
    }


    override fun getItemCount(): Int {
        return stat.size;
    }


}