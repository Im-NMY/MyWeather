package com.example.myweather.feature.weather_screen.data

import com.example.myweather.feature.weather_screen.domain.model.MainModel
import com.example.myweather.feature.weather_screen.domain.model.MainWeatherModel
import com.example.myweather.feature.weather_screen.domain.model.WindModel

class WeatherRepoImpl(private val weatherRemoteSource: WeatherRemoteSource) : WeatherRepo {

    override suspend fun getWeather(city: String): MainWeatherModel {
        return weatherRemoteSource.getWeather(city = city).toDomain()
    }

}