package com.softsquared.template.kotlin.src.trip.cityhome.tmodel

import com.google.gson.annotations.SerializedName

data class Photoid(
    @SerializedName("imgpath") val imgpath: String,
    @SerializedName("photoid") val photoid: Long,
    @SerializedName("thumbnailpath") val thumbnailpath: String
)