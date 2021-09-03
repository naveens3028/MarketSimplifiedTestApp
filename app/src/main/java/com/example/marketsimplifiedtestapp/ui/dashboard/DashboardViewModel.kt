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

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
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
                    var auditList : List<MyData>
                    auditList = response.body()!!
                    if (db != null) {
                        db.dataModelDao.addAvg(auditList)
                    }
                    isDataCallCompleted?.postValue(db?.dataModelDao?.getAll())
                    Log.e("poppers", db?.dataModelDao?.getAll().toString())
                    Toast.makeText(context, "success", Toast.LENGTH_LONG).show()
                }

            }
            override fun onFailure(call: Call<List<MyData>>, t: Throwable) {
                Log.e("poppers1", t.toString())
                Toast.makeText(context, "failed", Toast.LENGTH_LONG).show()
            }
        })
    }

}