package com.softsquared.template.kotlin.src.trip.cityhome.tmodel

import com.google.gson.annotations.SerializedName

data class TourList(
    @SerializedName("currentPage") val currentPage: Int,
    @SerializedName("items") val items: List<Item>,
    @SerializedName("pageCount") val pageCount: Int,
    @SerializedName("pageSize") val pageSize: Int,
    @SerializedName("result") val result: String,
    @SerializedName("resultCount") val resultCount: Int,
    @SerializedName("resultMessage") val resultMessage: String,
    @SerializedName("totalCount") val totalCount: Int
)