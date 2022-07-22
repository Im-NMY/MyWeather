package com.example.myweather.feature.weather_screen.data

class WeatherRepoImpl(private val weatherRemoteSource: WeatherRemoteSource) : WeatherRepo {

    override suspend fun getTemperature(): String {
        return weatherRemoteSource.getWeather().main.temperature
    }
    override suspend fun getWind(): String {
        return weatherRemoteSource.getWeather().wind.windDeg
    }
}