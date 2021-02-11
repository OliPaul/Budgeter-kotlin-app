package com.group10.budgeter.spend

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
import java.util.*
import kotlin.collections.HashMap

class NewSpendActivity: AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acticity_new_spend);
        btnSave.setOnClickListener(this);
        backToHome?.setOnClickListener(this)
    }

    fun goToHome(){
        startActivity(Intent(this, HomeScreenActivity::class.java))

    }

    override fun onClick(v: View?) {

        val database = Firebase.database;

        //Check fields value
        if(spend_title?.text.toString() != "" && spend_amount?.text.toString() != "" && spend_category?.text.toString() != ""){

            val spend = Spend(
                spend_title.text.toString(),
                spend_amount.text.toString().toDouble(),
                spend_category.text.toString(),
                spend_comment?.text.toString(),
                Date().toString(),
                "user01"
            );


            val myRef = database.getReference("spend");
            val spendAsMap = Gson().toJson(spend);

            myRef.push().setValue(spendAsMap)
                .addOnSuccessListener {
                    Toast.makeText(applicationContext,"Dépense enregistrée avec succès.",Toast.LENGTH_SHORT).show()
                    spend_title.setText("");
                    spend_amount.setText("");
                    spend_category.setText("");
                    spend_comment.setText("");
                }
                .addOnFailureListener{
                    Toast.makeText(applicationContext,"Une erreur est survenue lors de l'enregistrement de votre dépense.",Toast.LENGTH_LONG).show()
                };
        }else{
            Toast.makeText(applicationContext,"Remplissez correctement les champs obligatoires.",Toast.LENGTH_LONG).show()
        }


    when (v?.id) {
        R.id.backToHome -> {
            goToHome();
        }
    }

    }


}