package com.softsquared.template.kotlin.src.trip.plan

import android.os.Bundle
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentCityHomeBinding
import com.softsquared.template.kotlin.databinding.FragmentPlanBinding

class PlanFragment : BaseFragment<FragmentPlanBinding>(FragmentPlanBinding::bind, R.layout.fragment_plan) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}