package com.example.myweather

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val oneField = findViewById<TextView>(R.id.oneField)
        val btnField = findViewById<Button>(R.id.btnField)
        val search = findViewById<EditText>(R.id.Search)

        btnField.setOnClickListener(){
           Intent(this, WeatherActivity::class.java).also {startActivity(it)}

        }
    }
}