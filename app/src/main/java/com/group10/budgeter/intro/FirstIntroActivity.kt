package com.group10.budgeter.intro

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.group10.budgeter.MainActivity
import com.group10.budgeter.R
import kotlinx.android.synthetic.main.activity_first_intro.*

class FirstIntroActivity: AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_intro);
        btnNext?.setOnClickListener(this);
        btnSkip?.setOnClickListener(this);
    }

    fun goToNextIntro(){
        //Go to next intro activity
        startActivity(Intent(this, SecondIntroActivity::class.java));
    }

    fun goHome(){
        //Go to activity home page
        startActivity(Intent(this, MainActivity::class.java));
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btnNext -> {
                goToNextIntro();
            }
            R.id.btnSkip -> {
                goHome();
            }
        }
    }
}