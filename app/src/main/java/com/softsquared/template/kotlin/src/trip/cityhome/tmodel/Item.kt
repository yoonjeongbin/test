package com.softsquared.template.kotlin.src.trip.cityhome.tmodel

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("address") val address: String,
    @SerializedName("alltag") val alltag: String,
    @SerializedName("contentscd") val contentscd: Contentscd,
    @SerializedName("contentsid") val contentsid: String,
    @SerializedName("introduction") val introduction: String,
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("longitude") val longitude: Double,
    @SerializedName("phoneno") val phoneno: String,
    @SerializedName("postcode") val postcode: String,
    @SerializedName("region1cd") val region1cd: Region1cd,
    @SerializedName("region2cd") val region2cd: Region2cd,
    @SerializedName("repPhoto") val repPhoto: RepPhoto,
    @SerializedName("roadaddress") val roadaddress: String,
    @SerializedName("tag") val tag: String,
    @SerializedName("title") val title: String
)