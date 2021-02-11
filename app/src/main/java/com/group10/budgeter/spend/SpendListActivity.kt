package com.group10.budgeter.spend

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.group10.budgeter.R
import com.group10.budgeter.accueil.HomeScreenActivity
import com.group10.budgeter.spend.adapter.SpendListAdapter
import kotlinx.android.synthetic.main.activity_spend_list.*
import java.util.*
import kotlin.collections.HashMap

class SpendListActivity: AppCompatActivity(), OnSpendClicked,  View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spend_list);
        backToHome?.setOnClickListener(this);
        getSpendData();
    }

    fun goToHome() {
        startActivity(Intent(this, HomeScreenActivity::class.java))
    }

    fun getSpendData() {
        val database = Firebase.database;
        val myRef = database.getReference("spend");
        var spendList: MutableList<Spend> = mutableListOf();

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue<HashMap<String, Any>>()
                if (value != null) {
                    for (spend in value) {
                        spendList.add(Gson().fromJson(spend.value.toString(), Spend::class.java));
                    }

                    //Generate list
                    recyclerView?.apply {
                        layoutManager = LinearLayoutManager(this@SpendListActivity);
                        adapter = SpendListAdapter(spendList, this@SpendListActivity);
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("List Activity", "Failed to read value.", error.toException())
            }
        });
    }

    override fun onSpendClicked(spend: Spend?) {
        //Nothing to do
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.backToHome -> {
                goToHome();
            }
        }
    }
}