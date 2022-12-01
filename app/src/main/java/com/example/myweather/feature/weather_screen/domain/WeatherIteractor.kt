package com.example.myweather.feature.weather_screen.domain

import com.example.myweather.base.attempt
import com.example.myweather.feature.weather_screen.data.WeatherRepo

class WeatherIteractor(private val weatherRepo: WeatherRepo) {

    suspend fun getWeather(city: String) =
        attempt { weatherRepo.getWeather(city = city) }
}
