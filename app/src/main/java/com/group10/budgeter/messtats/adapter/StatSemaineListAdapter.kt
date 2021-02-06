package com.group10.budgeter.messtats.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.group10.budgeter.messtats.MesStatsSemaine
import com.group10.budgeter.messtats.holder.StatListViewHolder
import com.group10.budgeter.messtats.holder.StatSemaineListViewHolder

class StatSemaineListAdapter(
    private val statsemaine: List<MesStatsSemaine>): RecyclerView.Adapter<StatSemaineListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatSemaineListViewHolder {
        val inflater = LayoutInflater.from(parent.context);
        return StatSemaineListViewHolder(inflater, parent);
    }

    override fun onBindViewHolder(holder: StatSemaineListViewHolder, position: Int) {
        val statsemaine = statsemaine[position];
        holder.bind(statsemaine);

    }

    override fun getItemCount(): Int {
        return statsemaine.size;
    }

}