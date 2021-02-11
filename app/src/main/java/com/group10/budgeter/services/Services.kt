package com.group10.budgeter.services

import okhttp3.ResponseBody
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Services {
    private var userServices: UserService? = null

    init{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        userServices = retrofit.create(UserService::class.java);
    }

    fun getUser(callback: Callback<ResponseBody>){
        //Random user id
        val userID = (1..9).random();
        val call = userServices?.getUser(userID);
        call?.enqueue(callback);
    }
}
