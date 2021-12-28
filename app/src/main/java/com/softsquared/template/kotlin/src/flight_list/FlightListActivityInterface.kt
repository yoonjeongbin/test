package com.softsquared.template.kotlin.src.flight_list

import com.softsquared.template.kotlin.src.flight_list.fmodel.FlightList

interface FlightListActivityInterface {
    fun onGetFlightListSuccess(response : FlightList)

    fun onGetFlightListFailure(message: String)
}