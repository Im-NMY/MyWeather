package com.example.myweather.feature.weather_screen.domain.model

data class MainWeatherModel(
    val main: MainModel,
    val wind: WindModel,
    val sys: SysModel,
    val date: Long,
)
