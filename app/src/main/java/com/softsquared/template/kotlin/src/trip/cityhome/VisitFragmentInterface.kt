package com.softsquared.template.kotlin.src.trip.cityhome

import com.softsquared.template.kotlin.src.trip.cityhome.tmodel.TourList

interface VisitFragmentInterface {
    fun onGetTourDataSuccess(response : TourList)

    fun onGetTourDataFailure(message: String)
}