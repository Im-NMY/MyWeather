package com.example.myweather.feature.weather_screen.ui

import androidx.lifecycle.viewModelScope
import com.example.myweather.base.BaseViewModel
import com.example.myweather.base.Either
import com.example.myweather.base.Event
import com.example.myweather.feature.weather_screen.WeatherIteractor
import com.example.myweather.feature.weather_screen.ui.model.WeatherModel
import com.example.myweather.feature.weather_screen.ui.model.WindModel
import kotlinx.coroutines.launch

class WeatherScreenViewModel(val iteractor: WeatherIteractor): BaseViewModel<ViewState>() {

//    private suspend fun getWeather(city: String): Either<Throwable, WeatherModel> {
//        return iteractor.getWeather(city)
//    }
//
//    private suspend fun getWind(city: String): Either<Throwable, WindModel> {
//        return iteractor.getWind(city)
//    }

    override fun initialViewState(): ViewState =
        ViewState(temperature = "", wind = "", city = "", isLoading = false)

    override fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {
            is DataEvent.WeatherLoaded -> {

                viewModelScope.launch {
                    val city = event.city
                    iteractor.getWeather(city).fold(
                        onError = {
                            processDataEvent(DataEvent.OnWeatherFetchFailed(error = it))
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.OnWeatherFetchSucceed(temperature = it.temperature,city = city))
                        }
                    )
                    iteractor.getWind(city).fold(
                        onError = {
                            processDataEvent(DataEvent.OnWeatherFetchFailed(error = it))
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.OnWindFetchSucceed(wind = it.windDeg, city = city))
                        }
                    )
                }
                return previousState.copy(isLoading = true)
            }
            is DataEvent.OnWeatherFetchSucceed -> {
                return previousState.copy(isLoading = false, temperature = event.temperature, city = event.city)
            }
            is DataEvent.OnWindFetchSucceed -> {
                return previousState.copy(isLoading = false, wind = event.wind, city = event.city)
            }

//        is DataEvent.WeatherLoaded -> {
//            val city = event.city
//            val temperature = getWeather(city).temperature
//            val wind = getWind(city).windDeg
//            return previousState.copy(temperature = temperature, wind = wind, city= city)
//        }
        else -> return null
        }
    }
}


