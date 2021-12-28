package com.softsquared.template.kotlin.src.trip.cityhome

import com.softsquared.template.kotlin.src.trip.cityhome.tmodel.TourList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface VisitRetrofitInterface {
    @GET("searchList")
    fun getTourData(@Query("apiKey") apiKey : String,
                   @Query("locale") locale : String,
                   @Query("category") category : String,
                   @Query("page") page : Int,
                   @Query("cid") cid : String

    ) : Call<TourList>
}