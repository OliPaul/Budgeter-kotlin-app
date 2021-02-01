package com.group10.budgeter.spend

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.group10.budgeter.R
import com.group10.budgeter.spend.adapter.SpendListAdapter
import kotlinx.android.synthetic.main.activity_spend_list.*
import java.util.*

class SpendListActivity: AppCompatActivity(), OnSpendClicked{

    private val spendList: List<Spend> = listOf(
        Spend("Sandwich - Avocat",  10.00,"Alimentation", "", Date(), "user1"),
        Spend("Sandwich - Tomate",  12.50,"Alimentation", "", Date(), "user1"),
        Spend("Costume",  60.00,"Vêtements", "", Date(), "user1"),
        Spend("Costume",  60.00,"Vêtements", "", Date(), "user1"),
        Spend("Costume",  60.00,"Vêtements", "", Date(), "user1"),
        Spend("Costume",  60.00,"Vêtements", "", Date(), "user1"),
        Spend("Costume",  60.00,"Vêtements", "", Date(), "user1"),
        Spend("Costume",  60.00,"Vêtements", "", Date(), "user1"),
        Spend("Costume",  60.00,"Vêtements", "", Date(), "user1"),
        Spend("Costume",  60.00,"Vêtements", "", Date(), "user1"),
        Spend("Costume",  60.00,"Vêtements", "", Date(), "user1"),
        Spend("Costume",  60.00,"Vêtements", "", Date(), "user1"),

    );

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spend_list);
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(this@SpendListActivity);
            adapter = SpendListAdapter(spendList, this@SpendListActivity);
        }
    }

    override fun onSpendClicked(spend: Spend?) {
        //Nothing to do
    }
}