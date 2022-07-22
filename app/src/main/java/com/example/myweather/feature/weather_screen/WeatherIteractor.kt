package com.example.myweather.feature.weather_screen

import com.example.myweather.feature.weather_screen.data.WeatherRepo

class WeatherIteractor(private val weatherRepo: WeatherRepo) {

    suspend fun getWeather(): String{
        return weatherRepo.getTemperature()
    }
    suspend fun getWind(): String{
        return weatherRepo.getWind()
    }
}