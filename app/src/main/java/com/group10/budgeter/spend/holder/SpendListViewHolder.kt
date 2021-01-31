package com.group10.budgeter.spend.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.group10.budgeter.R
import com.group10.budgeter.spend.OnSpendClicked
import com.group10.budgeter.spend.Spend

class SpendListViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.spend_list_layout, parent, false)), View.OnClickListener {

    private var spendTitleText: TextView? = null;
    private var spendCategoryText: TextView? = null;
    private var spendDateText: TextView? = null;
    private var spendAmountText: TextView? = null;
    private var spend: Spend? = null;
    private var onSpendClicked: OnSpendClicked? = null;

    init {
        spendTitleText = itemView.findViewById(R.id.spend_title_text);
        spendCategoryText = itemView.findViewById(R.id.spend_category_text);
        spendDateText = itemView.findViewById(R.id.spend_date_text);
        spendAmountText = itemView.findViewById(R.id.spend_amount_text);
    }

    fun bind(spend: Spend, onSpendClicked: OnSpendClicked){
        this.spend = spend;
        this.onSpendClicked = onSpendClicked

        spendTitleText?.text = spend.spendTitle;
        spendCategoryText?.text = spend.spendCategory;
        spendDateText?.text = spend.spendDate.toString();
        spendAmountText?.text = spend.spendAmount.toString() + "€";

        itemView?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        onSpendClicked?.onSpendClicked(spend);
    }
}