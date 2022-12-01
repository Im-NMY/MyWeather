package com.example.myweather.feature.weather_screen.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myweather.R
import com.example.myweather.base.viewBinding
import com.example.myweather.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding { FragmentMainBinding.bind(it) }
    private val viewModel: MainViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnStart.setOnClickListener {
            viewModel.processDataEvent(UiEvent.LoadWeatherFromCity(binding.etStart.text.toString()))
            openWeather()
        }
    }

    private fun openWeather() {
        findNavController().navigate(R.id.action_mainFragment_to_secondFragment2)
    }
}