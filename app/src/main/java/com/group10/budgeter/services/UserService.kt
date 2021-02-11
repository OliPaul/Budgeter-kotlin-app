package com.group10.budgeter.services

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("users/{id}")
    fun getUser(@Path("id") userID: Int): Call<ResponseBody>
}