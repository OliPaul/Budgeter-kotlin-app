package com.group10.budgeter.intro

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.group10.budgeter.MainActivity
import com.group10.budgeter.R
import com.group10.budgeter.accueil.HomeScreenActivity
import com.group10.budgeter.services.Services
import kotlinx.android.synthetic.main.activity_second_intro.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        startActivity(Intent(this, HomeScreenActivity::class.java));
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btnBack -> {
                goToPreviousIntro();
            }
            R.id.btnGo -> {
                displayAlertUserID();
            }
        }
    }

    fun displayAlertUserID(){
        val userIDEditText = EditText(this)
        val dialog: AlertDialog = AlertDialog.Builder(this)
            .setTitle("Créer un votre pseudo")
            .setView(userIDEditText)
            .setPositiveButton("Valider", DialogInterface.OnClickListener { dialog, which ->
                val sharedPreferences = getSharedPreferences("Budgeter", MODE_PRIVATE);
                sharedPreferences.edit().putString("userID", userIDEditText.text.toString()).apply();
                sharedPreferences.edit().putBoolean("appAlreadyOpened", true).apply();
                goHome();
            })
            .create()
        dialog.show()
    }
}