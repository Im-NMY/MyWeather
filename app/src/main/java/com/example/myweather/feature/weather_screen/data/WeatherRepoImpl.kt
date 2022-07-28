package com.example.myweather.feature.weather_screen.data

import com.example.myweather.feature.weather_screen.ui.model.WeatherModel
import com.example.myweather.feature.weather_screen.ui.model.WindModel

class WeatherRepoImpl(private val weatherRemoteSource: WeatherRemoteSource) : WeatherRepo {

    override suspend fun getTemperature(city: String): WeatherModel {
        return weatherRemoteSource.getWeather(city).temperatureToDomain()
    }
    override suspend fun getWind(city:String): WindModel {
        return weatherRemoteSource.getWeather(city).windToDomain()
    }
}