package com.project.weather.network.model


import com.google.gson.annotations.SerializedName

data class ConsolidatedWeather(
    val id: Long,
    @SerializedName("the_temp")
    val theTemp: Double
)