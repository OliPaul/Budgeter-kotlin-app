package com.group10.budgeter.intro

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.group10.budgeter.MainActivity
import com.group10.budgeter.R
import kotlinx.android.synthetic.main.activity_second_intro.*

class SecondIntroActivity: AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_intro);
        btnGo?.setOnClickListener(this);
        btnBack?.setOnClickListener(this);
    }

    fun goToPreviousIntro(){
        //Go to previous intro activity
        startActivity(Intent(this, FirstIntroActivity::class.java));
    }

    fun goHome(){
        //Go to home activity
        startActivity(Intent(this, MainActivity::class.java));
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btnBack -> {
                goToPreviousIntro();
            }
            R.id.btnGo -> {
                goHome();
            }
        }
    }
}