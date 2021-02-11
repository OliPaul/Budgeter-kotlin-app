package com.group10.budgeter.spend

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.group10.budgeter.R
import com.group10.budgeter.accueil.HomeScreenActivity
import kotlinx.android.synthetic.main.acticity_new_spend.*
import kotlinx.android.synthetic.main.activity_second_intro.*
import java.util.*
import kotlin.collections.HashMap

class NewSpendActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acticity_new_spend);
        btnSave.setOnClickListener(this);
        backToHome.setOnClickListener(this);
    }

    override fun onClick(v: View?) {
        when (v) {
            backToHome -> startActivity(Intent(this, HomeScreenActivity::class.java))
            btnSave -> {
                val database = Firebase.database;
                //Get user pseudo
                val sharedPreferences = getSharedPreferences("Budgeter", Context.MODE_PRIVATE);
                val userID = sharedPreferences.getString("userID", null);
                //Get Amount limit
                val amountLimit: Double? = sharedPreferences.getString("amountLimit", "0")?.toDouble();

                if(spend_amount.text.toString().toDouble() > amountLimit!!){
                    Toast.makeText(
                        applicationContext,
                        "Vous avez excédé votre plafond de dépenses. Faites attention!",
                        Toast.LENGTH_LONG
                    ).show();
                }

                //Check fields value
                if (spend_title?.text.toString() != "" && spend_amount?.text.toString() != "" && spend_category?.text.toString() != "") {

                    val spend = userID?.let {
                        Spend(
                            spend_title.text.toString(),
                            spend_amount.text.toString().toDouble(),
                            spend_category.text.toString(),
                            spend_comment?.text.toString(),
                            Date().toString(),
                            it
                        )
                    };


                    val myRef = database.getReference("spend");

                    myRef.push().setValue(spend)
                        .addOnSuccessListener {
                            Toast.makeText(applicationContext, "Dépense enregistrée avec succès.", Toast.LENGTH_SHORT)
                                .show()
                            spend_title.setText("");
                            spend_amount.setText("");
                            spend_category.setText("");
                            spend_comment.setText("");
                        }
                        .addOnFailureListener {
                            Toast.makeText(
                                applicationContext,
                                "Une erreur est survenue lors de l'enregistrement de votre dépense.",
                                Toast.LENGTH_LONG
                            ).show()
                        };
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Remplissez correctement les champs obligatoires.",
                        Toast.LENGTH_LONG
                    ).show()
                }

            }
        }
    }


}