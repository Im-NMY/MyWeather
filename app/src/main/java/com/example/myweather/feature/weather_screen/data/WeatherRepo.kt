package com.example.myweather.feature.weather_screen.data

import com.example.myweather.feature.weather_screen.ui.model.WeatherModel
import com.example.myweather.feature.weather_screen.ui.model.WindModel

interface WeatherRepo {

   suspend fun getTemperature (city:String): WeatherModel

   suspend fun getWind(city:String): WindModel
}