package com.project.weather.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.project.weather.network.model.Location

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLocation(list : List<Location>)

    @Query("SELECT * FROM Location where title like :search")
    fun getLocation(search:String) : List<Location>
}