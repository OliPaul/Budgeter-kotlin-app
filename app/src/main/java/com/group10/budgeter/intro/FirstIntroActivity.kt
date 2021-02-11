package com.group10.budgeter.intro

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.group10.budgeter.MainActivity
import com.group10.budgeter.R
import kotlinx.android.synthetic.main.activity_first_intro.*
import android.database.sqlite.SQLiteDatabase

import android.content.ContentValues
import android.content.Context

import android.content.DialogInterface

import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.group10.budgeter.accueil.HomeScreenActivity


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
        startActivity(Intent(this, HomeScreenActivity::class.java));
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btnNext -> {
                goToNextIntro();
            }
            R.id.btnSkip -> {
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