package com.project.weather.network.model


import com.google.gson.annotations.SerializedName

data class Location(
    val latt_long: String,
    val location_type: String,
    val title: String,
    val woeid: Int
)