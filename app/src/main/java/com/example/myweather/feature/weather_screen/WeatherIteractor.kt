package com.example.myweather.feature.weather_screen

import com.example.myweather.base.Either
import com.example.myweather.base.attempt
import com.example.myweather.feature.weather_screen.data.WeatherRepo
import com.example.myweather.feature.weather_screen.ui.model.WeatherModel
import com.example.myweather.feature.weather_screen.ui.model.WindModel

class WeatherIteractor(private val weatherRepo: WeatherRepo) {

    suspend fun getWeather(city:String): Either<Throwable, WeatherModel> {
        return attempt { weatherRepo.getTemperature(city) }
    }
    suspend fun getWind(city:String): Either<Throwable, WindModel> {
        return attempt { weatherRepo.getWind(city) }
    }
}