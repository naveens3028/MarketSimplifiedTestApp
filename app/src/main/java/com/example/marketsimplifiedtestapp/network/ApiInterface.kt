package com.example.marketsimplifiedtestapp.network

import com.example.marketsimplifiedtestapp.database.model.MyData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("repositories")
    fun getDataFromGitHubRepo(): Call<List<MyData>>

}