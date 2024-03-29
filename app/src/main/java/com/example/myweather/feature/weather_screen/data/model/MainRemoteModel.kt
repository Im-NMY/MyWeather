package com.example.myweather.feature.weather_screen.data.model

import com.google.gson.annotations.SerializedName

data class MainRemoteModel(
    @SerializedName("temp")
    val temp: Float,
    @SerializedName("temp_max")
    val tempMax: Float,
    @SerializedName("temp_min")
    val tempMin: Float,
    @SerializedName("humidity")
    val humidity: Long,
    @SerializedName("pressure")
    val pressure: Long,
)
