package com.example.myweather.feature.weather_screen.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.myweather.R
import com.example.myweather.base.viewBinding
import com.example.myweather.databinding.FragmentSecondBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.text.SimpleDateFormat
import java.util.*

class SecondFragment : Fragment(R.layout.fragment_second) {

    private val binding by viewBinding { FragmentSecondBinding.bind(it) }
    private val viewModel: MainViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

    }

    @SuppressLint("SetTextI18n")
    private fun render(viewState: ViewState) {
        binding.loader.isVisible = !viewState.isLoading
        binding.address.text = viewState.city
        binding.temp.text = "${viewState.temp} °C"
        binding.tempMax.text = "${viewState.tempMax} °C"
        binding.tempMin.text = "${viewState.tempMin} °C"
        binding.wind.text = viewState.speed.toString()
        binding.pressure.text = viewState.pressure.toString()
        binding.humidity.text = viewState.humidity.toString()
        binding.sunrise.text =
            SimpleDateFormat("hh:mm a", Locale.UK).format(Date(viewState.sunrise * 1000))
        binding.sunset.text =
            SimpleDateFormat("hh:mm a", Locale.UK).format(Date(viewState.sunset * 1000))
        binding.updatedAt.text = SimpleDateFormat(
            "dd/MM/yyyy hh:mm a",
            Locale.ENGLISH
        ).format(Date(viewState.date * 1000))
    }

}
