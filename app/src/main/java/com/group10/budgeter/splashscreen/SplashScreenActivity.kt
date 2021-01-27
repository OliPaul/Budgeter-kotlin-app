package com.group10.budgeter.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.group10.budgeter.MainActivity
import com.group10.budgeter.R
import com.group10.budgeter.intro.FirstIntroActivity
import java.util.*
import kotlin.concurrent.schedule

class SplashScreenActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        navigateToRightActivity();
    }

    fun navigateToRightActivity(){
        //Go to another activity after
        Handler().postDelayed({
            startActivity(Intent(this, FirstIntroActivity::class.java))
        }, 5000)
    }

    fun activityToShow(){

    }
}