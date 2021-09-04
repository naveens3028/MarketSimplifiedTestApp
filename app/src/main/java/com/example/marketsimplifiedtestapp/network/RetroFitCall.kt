package com.example.marketsimplifiedtestapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetroFitCall {

    lateinit var retrofit: Retrofit
    private val BASE_URL = "https://api.github.com/"

    fun retroFitCall() {

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}