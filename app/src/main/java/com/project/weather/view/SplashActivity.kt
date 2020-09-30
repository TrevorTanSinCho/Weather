package com.project.weather.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.project.weather.R
import com.project.weather.room.WeatherDatabase

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        WeatherDatabase.get(application)

        Handler().postDelayed({
            startActivity(Intent(this, SearchActivity::class.java))
            finish()
        }, 2000)
    }
}