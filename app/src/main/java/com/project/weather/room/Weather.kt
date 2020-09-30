package com.project.weather.room

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.project.weather.network.model.ConsolidatedWeather
import com.project.weather.network.model.Location

@Database(version = 1, entities = [Location::class,ConsolidatedWeather::class])
abstract class WeatherDatabase : RoomDatabase() {
    companion object{
        fun get(application: Application) : WeatherDatabase{
            return Room.databaseBuilder(application, WeatherDatabase::class.java, "weather").build()
        }
    }

    abstract fun getWeatherDao() : WeatherDao
}