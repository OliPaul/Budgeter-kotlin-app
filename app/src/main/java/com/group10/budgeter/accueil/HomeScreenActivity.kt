package com.group10.budgeter.accueil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.group10.budgeter.R
import com.group10.budgeter.spend.NewSpendActivity

class HomeScreenActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
    }

    override fun onClick(v: View?) {
        NewSpendActivity.navigateTo(this, 15)
    }
}