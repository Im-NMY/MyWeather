package com.example.myweather

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myweather.feature.weather_screen.ui.UiEvent
import com.example.myweather.feature.weather_screen.ui.ViewState
import com.example.myweather.feature.weather_screen.ui.WeatherScreenViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherActivity : AppCompatActivity() {


    private val viewModel: WeatherScreenViewModel by viewModel()
    private val Temperature: TextView by lazy { findViewById(R.id.Temperature) }
    private val Wind: TextView by lazy { findViewById(R.id.Wind) }
    private val Tap: Button by lazy { findViewById(R.id.Tap) }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        viewModel.viewState.observe(this, ::render)

        Tap.setOnClickListener {
            viewModel.processUiEvent(UiEvent.OnButtonClicked)
        }
    }
    private fun render(viewState: ViewState){
        Temperature.text = "Температура: ${viewState.temperature} С"
        Wind.text = "Направление ветра: ${viewState.wind}"

    }
}