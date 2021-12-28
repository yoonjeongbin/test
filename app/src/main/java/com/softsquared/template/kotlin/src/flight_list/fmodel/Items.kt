package com.softsquared.template.kotlin.src.flight_list.fmodel

import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("item") val item: List<Item>
)