package com.softsquared.template.kotlin.src.main.test

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentTestBinding

class TestFragment : BaseFragment<FragmentTestBinding>(FragmentTestBinding::bind, R.layout.fragment_test) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showCustomToast("테스트중")
    }
}