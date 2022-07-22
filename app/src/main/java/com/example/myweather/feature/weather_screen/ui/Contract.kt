package com.example.myweather.feature.weather_screen.ui

import android.icu.text.CaseMap
import com.example.myweather.base.Event

data class ViewState (
    val temperature: String,
    val wind: String
    )
sealed class UiEvent: Event {
   object OnButtonClicked : UiEvent()
}