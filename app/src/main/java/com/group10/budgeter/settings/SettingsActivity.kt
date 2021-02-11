package com.group10.budgeter.settings

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.group10.budgeter.R
import com.group10.budgeter.accueil.HomeScreenActivity
import kotlinx.android.synthetic.main.acticity_settings.*
import kotlinx.android.synthetic.main.activity_spend_list.*

class SettingsActivity: AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acticity_settings);
        settingToHome.setOnClickListener(this);
        settingAmountLimit.doAfterTextChanged {
            if(!settingAmountLimit.hasFocus()){
                val sharedPreferences = getSharedPreferences("Budgeter", Context.MODE_PRIVATE);
                sharedPreferences.edit().putString("amountLimit", settingAmountLimit.text.toString());
            }
        }
    }

    override fun onClick(v: View?) {
        startActivity(Intent(this, HomeScreenActivity::class.java))
    }
}