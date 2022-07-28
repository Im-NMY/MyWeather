package com.example.myweather

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.myweather.feature.weather_screen.ui.DataEvent
import com.example.myweather.feature.weather_screen.ui.ViewState
import com.example.myweather.feature.weather_screen.ui.WeatherScreenViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherActivity : AppCompatActivity() {


    private val viewModel: WeatherScreenViewModel by viewModel()
    private val temperature: TextView by lazy { findViewById(R.id.Temperature) }
    private val wind: TextView by lazy { findViewById(R.id.Wind) }
    private val progressBar: ProgressBar by lazy { findViewById(R.id.ProgressBar) }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val city: String = intent.getStringExtra("city").toString()

        viewModel.viewState.observe(this, ::render)
        viewModel.processDataEvent(DataEvent.WeatherLoaded(city))
    }

    private fun render(viewState: ViewState){
        progressBar.isVisible = viewState.isLoading
        temperature.text = "Температура: ${viewState.temperature} С"
        wind.text = "Направление ветра: ${viewState.wind}"

    }
}