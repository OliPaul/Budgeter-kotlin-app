package com.group10.budgeter.accueil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.group10.budgeter.MainActivity
import com.group10.budgeter.R
import com.group10.budgeter.intro.SecondIntroActivity
import com.group10.budgeter.messtats.StatListActivity
import com.group10.budgeter.settings.SettingsActivity
//import com.group10.budgeter.messtats.StatListActivity
import com.group10.budgeter.spend.NewSpendActivity
import com.group10.budgeter.spend.SpendListActivity
import kotlinx.android.synthetic.main.activity_first_intro.*
import kotlinx.android.synthetic.main.activity_home_screen.*

class HomeScreenActivity() : AppCompatActivity(), View.OnClickListener {
    companion object
    {
        val REQUEST_CODE = 32
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        newSpentButton?.setOnClickListener(this);
        spentListButton?.setOnClickListener(this);
        statsButton?.setOnClickListener(this);
        settingsButton?.setOnClickListener(this);


       /*val button1 = findViewById<Button>(R.id.newSpentButton)
        button1.setOnClickListener{
            val intent = Intent(this@HomeScreenActivity, NewSpendActivity::class.java)
            startActivity(intent)
        }
        val button2 = findViewById<Button>(R.id.spentListButton)
        button2.setOnClickListener{
            val intent = Intent(this@HomeScreenActivity, SpendListActivity::class.java)
            startActivity(intent)
        }
        /*val button3 = findViewById<Button>(R.id.statsButton)
        button3.setOnClickListener{
            val intent = Intent(this@HomeScreenActivity,  StatListActivity::class.java)
            startActivity(intent)
        }*/
        val button4 = findViewById<Button>(R.id.settingsButton)
        button4.setOnClickListener{
            val intent = Intent(this, NewSpendActivity::class.java)
            startActivity(intent)
        }*/
    }


    fun goToNewSpentActivity(){
        startActivity(Intent(this@HomeScreenActivity, NewSpendActivity::class.java))
    }

    fun goToSpentListActivity(){
        startActivity(Intent(this@HomeScreenActivity, SpendListActivity::class.java))
    }

    fun goToStatsActivity(){
        startActivity((Intent(this@HomeScreenActivity, StatListActivity::class.java)))
    }
    fun goToSettingsActivity(){
        startActivity(Intent(this@HomeScreenActivity, SettingsActivity::class.java))
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.newSpentButton -> {
                goToNewSpentActivity();
            }
            R.id.spentListButton -> {
                goToSpentListActivity();
            }
            R.id.statsButton -> {
                goToStatsActivity()
            }
            R.id.settingsButton -> {
                goToSettingsActivity()
            }

        }
    }
}