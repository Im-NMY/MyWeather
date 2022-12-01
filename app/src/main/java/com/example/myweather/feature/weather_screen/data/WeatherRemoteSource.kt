package com.example.myweather.feature.weather_screen.data

import com.example.myweather.feature.weather_screen.data.model.MainWeatherRemoteModel

class WeatherRemoteSource(private val api: WeatherApi) {

    suspend fun getWeather(city: String): MainWeatherRemoteModel = api.getWeather(query = city)

}