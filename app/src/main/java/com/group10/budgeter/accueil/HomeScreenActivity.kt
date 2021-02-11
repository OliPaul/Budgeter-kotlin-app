package com.group10.budgeter.accueil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.group10.budgeter.R
import com.group10.budgeter.messtats.StatListActivity
import com.group10.budgeter.spend.NewSpendActivity
import com.group10.budgeter.spend.SpendListActivity

class HomeScreenActivity() : AppCompatActivity(), View.OnClickListener {
    companion object
    {
        val REQUEST_CODE = 32
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        val button1 = findViewById<Button>(R.id.newSpentButton)
        button1.setOnClickListener{
            val intent = Intent(this, NewSpendActivity::class.java)
            //HomeScreenActivity(intent)
        }
        val button2 = findViewById<Button>(R.id.spentListButton)
        button2.setOnClickListener{
            val intent = Intent(this, SpendListActivity::class.java)
            //HomeScreenActivity(intent)
        }
        val button3 = findViewById<Button>(R.id.statsButton)
        button3.setOnClickListener{
            val intent = Intent(this,  StatListActivity::class.java)
            //HomeScreenActivity(intent)
        }
        val button4 = findViewById<Button>(R.id.settingsButton)
        button4.setOnClickListener{
            val intent = Intent(this, NewSpendActivity::class.java)
            //HomeScreenActivity(intent)
        }
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

    /*override fun onClick(v: View?) {
        NewSpendActivity.navigateTo(this, 15)
    }*/

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (resultCode)
        {
            REQUEST_CODE ->
            {
                val value = data?.getStringExtra(NewSpendActivity.RESULT_KEY)
                button_1?.text = value
            }
        }
    }*/
}