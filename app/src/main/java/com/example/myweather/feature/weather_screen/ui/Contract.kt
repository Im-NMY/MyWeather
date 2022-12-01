package com.example.myweather.feature.weather_screen.ui

import com.example.myweather.base.Event
import com.example.myweather.feature.weather_screen.domain.model.MainWeatherModel


data class ViewState (
    val temp: Float,
    val tempMax: Float,
    val tempMin: Float,
    val pressure: Long,
    val humidity: Long,
    val sunrise: Long,
    val sunset: Long,
    val date: Long,
    val speed: Float,
    val isLoading: Boolean,
    var city: String
    )

sealed class DataEvent: Event {
    object WeatherLoaded: DataEvent()
    data class OnWeatherSucceed(val data: MainWeatherModel) : DataEvent()
}
sealed class UiEvent: Event {
    data class LoadWeatherFromCity(val city: String): UiEvent()

}


