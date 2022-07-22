package com.example.myweather

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.ViewSwitcher
import com.example.myweather.feature.weather_screen.ui.UiEvent
import com.example.myweather.feature.weather_screen.ui.ViewState
import com.example.myweather.feature.weather_screen.ui.WeatherScreenViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val btnField: Button by lazy { findViewById(R.id.btnField) }
    private val oneField: TextView by lazy { findViewById(R.id.oneField) }
    private val search: EditText by lazy { findViewById(R.id.Search) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        search.text.toString()

        btnField.setOnClickListener() {
            Intent(this, WeatherActivity::class.java).also { startActivity(it) }

        }

    }

}