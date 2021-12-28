package com.softsquared.template.kotlin.src.flight_list

import com.softsquared.template.kotlin.src.flight_list.fmodel.FlightList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FlightListRetrofitInterface {
    @GET("getFlightOpratInfoList")
    fun getFlightList(@Query("serviceKey") serviceKey : String,
                      @Query("numOfRows") numOfRows : Int,
                      @Query("pageNo") lon : Int,
                      @Query("depAirportId") depAirportId : String,
                      @Query("arrAirportId") arrAirportId : String,
                      @Query("depPlandTime") depPlandTime : Int,
                      @Query("airlineId") airlineId : String,
                      @Query("_type") _type: String = "json"

    ) : Call<FlightList>
}