package com.project.weather.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.project.weather.network.BASE_URL
import com.project.weather.network.WeatherNetwork
import com.project.weather.network.model.Location
import com.project.weather.network.model.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchActivityRepository(val application: Application) {
    val showProgress = MutableLiveData<Boolean>()

    fun changeState(){
        showProgress.value = showProgress.value != null && showProgress.value!!
    }

    fun searchLocation(searchString: String){
        showProgress.value = true
        //Networkcall

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

        val service = retrofit.create(WeatherNetwork::class.java)

        service.getWeather("2295424").enqueue(object : Callback<WeatherResponse>{
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                showProgress.value = false
                Toast.makeText(application,"Error while accessing the API", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                Log.d("SearchRepository","Response : ${Gson().toJson(response.body())}")
                showProgress.value = false
            }

        })
//        service.getLocation(searchString).enqueue(object : Callback<List<Location>>{
//            override fun onFailure(call: Call<List<Location>>, t: Throwable) {
//                showProgress.value = false
//                Toast.makeText(application,"Error while accessing the API", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onResponse(
//                call: Call<List<Location>>,
//                response: Response<List<Location>>
//            ) {
//                Log.d("SearchRepository","Response : ${Gson().toJson(response.body())}")
//                showProgress.value = false
//            }
//
//        })
    }
}