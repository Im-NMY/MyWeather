package com.example.myweather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class WeatherActivity : AppCompatActivity() {
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)


    }
}