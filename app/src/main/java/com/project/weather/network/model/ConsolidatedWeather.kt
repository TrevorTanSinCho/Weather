package com.project.weather.network.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class ConsolidatedWeather(
    @PrimaryKey val id: Long,
    @SerializedName("the_temp")
    val theTemp: Double
)