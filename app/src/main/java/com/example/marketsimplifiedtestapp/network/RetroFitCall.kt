package com.example.marketsimplifiedtestapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetroFitCall {

    lateinit var retrofit: Retrofit

    fun retroFitCall(url: String) {

        retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}