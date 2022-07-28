package com.example.myweather.feature.weather_screen.ui

import com.example.myweather.base.Event


data class ViewState (
    val temperature: String,
    val wind: String,
    val city: String,
    val isLoading: Boolean
    )

sealed class DataEvent: Event {
    data class WeatherLoaded(val city: String) : DataEvent()

    data class OnWeatherFetchSucceed(val temperature: String, val city: String) : DataEvent()

    data class OnWindFetchSucceed(val wind: String, val city: String) : DataEvent()

    data class OnWeatherFetchFailed(val error: Throwable) : DataEvent()
}

