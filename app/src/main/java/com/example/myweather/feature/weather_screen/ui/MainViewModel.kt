package com.example.myweather.feature.weather_screen.ui

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.myweather.base.BaseViewModel
import com.example.myweather.base.Event
import com.example.myweather.feature.weather_screen.domain.WeatherIteractor
import kotlinx.coroutines.launch

class MainViewModel(val iteractor: WeatherIteractor) : BaseViewModel<ViewState>() {


    override fun initialViewState(): ViewState =
        ViewState(
            temp = 0f,
            tempMax = 0f,
            speed = 0f,
            tempMin = 0f,
            pressure = 0,
            city = "",
            humidity = 0,
            sunset = 0,
            sunrise = 0,
            date = 0,
            isLoading = false
        )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.LoadWeatherFromCity -> {
                previousState.city = event.city
                viewModelScope.launch {
                    iteractor.getWeather(event.city).fold(
                        onError = {
                            Log.e("Error", it.localizedMessage)
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.OnWeatherSucceed(it))
                        }
                    )
                }
                return null
            }
            is DataEvent.OnWeatherSucceed -> {
                return previousState.copy(
                    temp = event.data.main.temp,
                    tempMax = event.data.main.tempMax,
                    speed = event.data.wind.speed,
                    tempMin = event.data.main.tempMin,
                    pressure = event.data.main.pressure,
                    humidity = event.data.main.humidity,
                    sunset = event.data.sys.sunset,
                    sunrise = event.data.sys.sunrise,
                    date = event.data.date,
                    isLoading = true
                )
            }
            else -> return null
        }
    }
}


