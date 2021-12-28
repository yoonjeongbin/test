package com.softsquared.template.kotlin.src.flight_list.fmodel

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("airlineNm") val airlineNm: String,
    @SerializedName("arrAirportNm") val arrAirportNm: String,
    @SerializedName("arrPlandTime") val arrPlandTime: Long,
    @SerializedName("depAirportNm") val depAirportNm: String,
    @SerializedName("depPlandTime") val depPlandTime: Long,
    @SerializedName("economyCharge") val economyCharge: Int,
    @SerializedName("prestigeCharge") val prestigeCharge: Int,
    @SerializedName("vihicleId") val vihicleId: String
)