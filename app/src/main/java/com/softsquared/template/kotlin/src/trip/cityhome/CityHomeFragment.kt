package com.softsquared.template.kotlin.src.trip.cityhome

import android.content.Context
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentCityHomeBinding
import com.softsquared.template.kotlin.src.trip.TripActivity

class CityHomeFragment : BaseFragment<FragmentCityHomeBinding>(FragmentCityHomeBinding::bind, R.layout.fragment_city_home) {
    var activity : TripActivity? = TripActivity()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvCityHomeTitle.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        binding.tvCityHomeTour.setOnClickListener {
            activity?.onFragmentChange(1)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = getActivity() as TripActivity
    }

    override fun onDetach() {
        super.onDetach()
        activity = null
    }
}