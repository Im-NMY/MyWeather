package com.example.myweather.feature.weather_screen.ui

import androidx.lifecycle.ViewModel
import com.example.myweather.base.BaseViewModel
import com.example.myweather.base.Event
import com.example.myweather.feature.weather_screen.WeatherIteractor

class WeatherScreenViewModel(val iteractor: WeatherIteractor): BaseViewModel<ViewState>() {

   suspend fun getWeather(): String{
        return iteractor.getWeather()
    }
    suspend fun getWind(): String{
        return iteractor.getWind()
    }

    override fun initialViewState(): ViewState = ViewState(temperature = "", wind = "")


    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        val temperature = getWeather()
        val wind = getWind()
       when(event){
           is UiEvent.OnButtonClicked -> {
              val temperature = getWeather()
               val wind = getWind()
               return previousState.copy(temperature = temperature, wind = wind)
           }
           else ->
               return previousState.copy(temperature = temperature, wind = wind)
       }
    }
}