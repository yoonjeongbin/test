package com.softsquared.template.kotlin.src.trip.triptool

import com.softsquared.template.kotlin.src.trip.triptool.model.WeatherResponse

interface TripToolFragmentInterface {
    fun onGetWeatherSuccess(response : WeatherResponse)

    fun onGetWeatherFailure(message: String)
}