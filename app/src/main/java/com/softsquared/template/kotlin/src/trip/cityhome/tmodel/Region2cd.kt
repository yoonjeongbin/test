package com.softsquared.template.kotlin.src.trip.cityhome.tmodel

import com.google.gson.annotations.SerializedName

data class Region2cd(
    @SerializedName("label") val label: String,
    @SerializedName("refId") val refId: String,
    @SerializedName("value") val value: String
)