package com.example.myweather.feature.weather_screen.di

import com.example.myweather.feature.weather_screen.domain.WeatherIteractor
import com.example.myweather.feature.weather_screen.data.WeatherApi
import com.example.myweather.feature.weather_screen.data.WeatherRemoteSource
import com.example.myweather.feature.weather_screen.data.WeatherRepo
import com.example.myweather.feature.weather_screen.data.WeatherRepoImpl
import com.example.myweather.feature.weather_screen.ui.MainViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val API_KEY = "5f3e74caa31e4586e2cb64ded566bd82"
const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
val weatherScreenModule = module {

    single<OkHttpClient> { OkHttpClient.
    Builder().
    build()
    }

    single<Retrofit> {  Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(get<OkHttpClient>())
        .build()
    }

    single<WeatherApi > { get<Retrofit>().create(WeatherApi::class.java) }

    single { WeatherRemoteSource(get<WeatherApi>()) }

    single<WeatherRepo> { WeatherRepoImpl(get<WeatherRemoteSource>()) }

    single { WeatherIteractor(get<WeatherRepo>()) }

    viewModel { MainViewModel(get<WeatherIteractor>()) }
}


