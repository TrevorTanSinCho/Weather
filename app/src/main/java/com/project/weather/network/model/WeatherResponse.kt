package com.project.weather.network.model


import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("consolidated_weather")
    val consolidatedWeather: List<ConsolidatedWeather>,
    val time: String,
    val title: String,
    val woeid: Int
)