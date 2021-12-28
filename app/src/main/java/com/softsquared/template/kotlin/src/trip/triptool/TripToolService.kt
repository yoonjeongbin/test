package com.softsquared.template.kotlin.src.trip.triptool

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.trip.triptool.model.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TripToolService(val tripToolFragmentInterface: TripToolFragmentInterface) {

    fun tryGetWeather(lat : Double, lon : Double, exclude : String, key : String){
        val tripToolRetrofitInterface = ApplicationClass.wRetrofit.create(TripToolRetrofitInterface::class.java)
        tripToolRetrofitInterface.getWeather(lat,lon,exclude,key).enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                tripToolFragmentInterface.onGetWeatherSuccess(response.body() as WeatherResponse)
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                tripToolFragmentInterface.onGetWeatherFailure(t.message ?: "통신 오류")
            }
        })
    }

}