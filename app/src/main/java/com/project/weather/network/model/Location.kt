package com.project.weather.network.model


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("latt_long")
    val lattLong: String,
    @SerializedName("location_type")
    val locationType: String,
    val title: String,
    val woeid: Int
)