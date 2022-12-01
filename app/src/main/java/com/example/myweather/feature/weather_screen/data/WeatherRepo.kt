package com.example.myweather.feature.weather_screen.data

import com.example.myweather.feature.weather_screen.domain.model.MainWeatherModel

interface WeatherRepo {

    suspend fun getWeather(city: String): MainWeatherModel

}