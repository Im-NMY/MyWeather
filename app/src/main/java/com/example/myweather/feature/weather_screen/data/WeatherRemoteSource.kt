package com.example.myweather.feature.weather_screen.data

import com.example.myweather.MainActivity
import com.example.myweather.feature.weather_screen.data.model.WeatherRemoteModel

class WeatherRemoteSource(private val api: WeatherApi) {

   suspend fun getWeather (city: String =""): WeatherRemoteModel {
        return api.getWeather(query = "")

    }
}