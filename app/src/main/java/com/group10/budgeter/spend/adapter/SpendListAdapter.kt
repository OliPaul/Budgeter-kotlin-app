package com.group10.budgeter.spend.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.group10.budgeter.spend.OnSpendClicked
import com.group10.budgeter.spend.Spend
import com.group10.budgeter.spend.SpendListActivity
import com.group10.budgeter.spend.holder.SpendListViewHolder

class SpendListAdapter(
    private val spend: List<Spend>,
    private val onSpendClicked: OnSpendClicked
) : RecyclerView.Adapter<SpendListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpendListViewHolder {
        val inflater = LayoutInflater.from(parent.context);
        return SpendListViewHolder(inflater, parent);
    }

    override fun onBindViewHolder(holder: SpendListViewHolder, position: Int) {
        val spend = spend[position];
        holder.bind(spend, onSpendClicked);
    }

    override fun getItemCount(): Int {
        return spend.size;
    }


}