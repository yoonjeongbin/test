package com.softsquared.template.kotlin.src.trip.triptool.model

import com.google.gson.annotations.SerializedName

data class WeatherXX(
    @SerializedName("description") val description: String,
    @SerializedName("icon") val icon: String,
    @SerializedName("id") val id: Int,
    @SerializedName("main") val main: String
)