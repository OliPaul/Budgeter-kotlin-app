package com.group10.budgeter.accueil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.group10.budgeter.R
import com.group10.budgeter.spend.NewSpendActivity
import kotlinx.android.synthetic.main.activity_home_screen.*

class HomeScreenActivity : AppCompatActivity(), View.OnClickListener {
    companion object
    {
        val REQUEST_CODE = 32
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        button_1.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        NewSpendActivity.navigateTo(this, 15)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (resultCode)
        {
            REQUEST_CODE ->
            {
                val value = data?.getStringExtra(NewSpendActivity.RESULT_KEY)
                button_1?.text = value
            }
        }
    }
}