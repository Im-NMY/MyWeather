package com.example.myweather.feature.weather_screen.data.model

import com.google.gson.annotations.SerializedName

data class  WindRemoteModel(
    @SerializedName("speed")
    val speed: Float,
)