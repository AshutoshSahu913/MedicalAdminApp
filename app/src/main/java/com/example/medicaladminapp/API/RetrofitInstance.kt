package com.example.medicaladminapp.API

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val client: OkHttpClient = OkHttpClient.Builder().build()

    val api = Retrofit.Builder()
        .client(client)
        .baseUrl(ApiServices.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiServices::class.java)
}