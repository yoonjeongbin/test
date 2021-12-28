package com.softsquared.template.kotlin.src.trip.cityhome.tmodel

import com.google.gson.annotations.SerializedName

data class RepPhoto(
    @SerializedName("descseo") val descseo: String,
    @SerializedName("photoid") val photoid: Photoid
)