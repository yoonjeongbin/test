package com.softsquared.template.kotlin.src.flight_list.fmodel

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("body") val body: Body,
    @SerializedName("header") val header: Header
)