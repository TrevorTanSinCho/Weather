package com.project.weather.network.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity//(primaryKeys = ["latt_long","woeid"])
data class Location(
    //@PrimaryKey(autoGenerate = true)
    val latt_long: String,
    val location_type: String,
    val title: String,
    @PrimaryKey val woeid: Int
)