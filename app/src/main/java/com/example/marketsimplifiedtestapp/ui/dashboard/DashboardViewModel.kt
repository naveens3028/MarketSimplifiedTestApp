package com.example.marketsimplifiedtestapp.ui.dashboard

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marketsimplifiedtestapp.database.AppDataBase
import com.example.marketsimplifiedtestapp.database.model.MyData
import com.example.marketsimplifiedtestapp.network.ApiInterface
import com.example.marketsimplifiedtestapp.network.RetroFitCall
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardViewModel : ViewModel() {

    val isDataCallCompleted: MutableLiveData<List<MyData>>? =  MutableLiveData<List<MyData>>()

    fun getApiCall(context: Context, db: AppDataBase?) {
        RetroFitCall.retroFitCall("https://api.github.com/")
        val service = RetroFitCall.retrofit.create(ApiInterface::class.java)
        val call = service.getDataFromGitHubRepo()
        call.enqueue(object : Callback<List<MyData>> {
            override fun onResponse(
                call: Call<List<MyData>>,
                response: Response<List<MyData>>
            ) {
                if (response.code() == 200) {
                    var auditList : List<MyData> = response.body()!!
                    db?.dataModelDao?.addAvg(auditList)
                    isDataCallCompleted?.postValue(db?.dataModelDao?.getAll())
                }

            }
            override fun onFailure(call: Call<List<MyData>>, t: Throwable) {
                Toast.makeText(context, "failed", Toast.LENGTH_LONG).show()
            }
        })
    }

}