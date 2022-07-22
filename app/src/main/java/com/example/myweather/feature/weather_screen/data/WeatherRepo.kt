package com.example.myweather.feature.weather_screen.data

interface WeatherRepo {

   suspend fun getTemperature(): String

   suspend fun getWind(): String
}