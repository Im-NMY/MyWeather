package com.example.myweather

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    private val btnField: Button by lazy { findViewById(R.id.btnField) }
    private val search: EditText by lazy { findViewById(R.id.Search) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val city = search.text.toString()
//        btnField.setOnClickListener() {
//            Intent(this, WeatherActivity::class.java).also { startActivity(it) }
//        }
        btnField.setOnClickListener() {
            if (search.text.toString().trim() == "")
                Toast.makeText(this, "Введите город", Toast.LENGTH_SHORT).show()
            else {

            val city = search.text.toString()
            val intent = Intent(this, WeatherActivity::class.java)
            Intent(intent)
            intent.putExtra("city", city)
            startActivity(intent);
            }
        }
    }
}