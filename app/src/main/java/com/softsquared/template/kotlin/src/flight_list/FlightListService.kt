package com.softsquared.template.kotlin.src.flight_list

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.flight_list.fmodel.FlightList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlightListService(val flightListActivityInterface: FlightListActivityInterface) {
    fun tryFlightListData(key: String, num: Int, no: Int, goId: String, arriveId: String, goDate: Int, airline: String){
        val flightListRetrofitInterface = ApplicationClass.fRetrofit.create(FlightListRetrofitInterface::class.java)
        flightListRetrofitInterface.getFlightList(key,num,no,goId,arriveId,goDate,airline).enqueue(object : Callback<FlightList> {
            override fun onResponse(call: Call<FlightList>, response: Response<FlightList>) {
                flightListActivityInterface.onGetFlightListSuccess(response.body() as FlightList)
            }

            override fun onFailure(call: Call<FlightList>, t: Throwable) {
                flightListActivityInterface.onGetFlightListFailure(t.message ?: "통신 오류")
            }
        })
    }
}