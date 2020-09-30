package com.project.weather.repository

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.project.weather.network.BASE_URL
import com.project.weather.network.WeatherNetwork
import com.project.weather.network.model.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailsActivityRepository(val application: Application) {

    val showProgress = MutableLiveData<Boolean>()
    val response = MutableLiveData<WeatherResponse>()

    fun getWeather(woeid : Int){
        showProgress.value = true

        val retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

        val service = retrofit.create(WeatherNetwork::class.java)

        service.getWeather(woeid).enqueue(object : Callback<WeatherResponse> {
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                showProgress.value = false
                Toast.makeText(application,"Error while accessing the API", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<WeatherResponse>,
                resp: Response<WeatherResponse>
            ) {
                response.value = resp.body()
                showProgress.value = false
            }

        })
    }
}