package com.example.myweather.feature.weather_screen.data.model

import com.google.gson.annotations.SerializedName

data class  WeatherWindRemoteModel(
    @SerializedName("deg")
    val windDeg: String
)