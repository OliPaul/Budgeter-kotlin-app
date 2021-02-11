package com.group10.budgeter.settings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.group10.budgeter.R
import com.group10.budgeter.accueil.HomeScreenActivity
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity(),  View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        backToHome?.setOnClickListener(this);
    }

    fun goToHome(){
        startActivity(Intent(this, HomeScreenActivity::class.java))
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.backToHome -> {
                goToHome()
            }

        }
    }
}