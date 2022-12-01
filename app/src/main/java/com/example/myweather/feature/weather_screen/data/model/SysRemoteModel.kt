package com.example.myweather.feature.weather_screen.data.model

import com.google.gson.annotations.SerializedName

data class SysRemoteModel(
    @SerializedName("sunrise")
    val sunrise: Long,
    @SerializedName("sunset")
    val sunset: Long,
)
