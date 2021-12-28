package com.softsquared.template.kotlin.src.flight_list.fmodel

import com.google.gson.annotations.SerializedName

data class Header(
    @SerializedName("resultCode") val resultCode: String,
    @SerializedName("resultMsg") val resultMsg: String
)