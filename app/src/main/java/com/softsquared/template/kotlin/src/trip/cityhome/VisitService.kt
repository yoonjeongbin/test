package com.softsquared.template.kotlin.src.trip.cityhome

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.trip.cityhome.tmodel.TourList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VisitService (val visitFragmentInterface: VisitFragmentInterface){
    fun tryGetTourData(key: String, locale: String, category: String, page: Int, cid: String){
        val visitRetrofitInterface = ApplicationClass.vRetrofit.create(VisitRetrofitInterface::class.java)
        visitRetrofitInterface.getTourData(key,locale, category, page, cid).enqueue(object : Callback<TourList> {
            override fun onResponse(call: Call<TourList>, response: Response<TourList>) {
                visitFragmentInterface.onGetTourDataSuccess(response.body() as TourList)
            }

            override fun onFailure(call: Call<TourList>, t: Throwable) {
                visitFragmentInterface.onGetTourDataFailure(t.message ?: "통신 오류")
            }
        })
    }
}