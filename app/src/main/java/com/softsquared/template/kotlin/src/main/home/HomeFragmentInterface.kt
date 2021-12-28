package com.softsquared.template.kotlin.src.main.home

import com.softsquared.template.kotlin.src.main.home.models.SignUpResponse
import com.softsquared.template.kotlin.src.main.home.models.UserResponse
import com.softsquared.template.kotlin.src.main.home.models.UserSearchResponse

interface HomeFragmentInterface {

    fun onGetUserSuccess(response: UserResponse)

    fun onGetUserFailure(message: String)

    fun onPostSignUpSuccess(response: SignUpResponse)

    fun onPostSignUpFailure(message: String)

    fun onGetUserSearchSuccess(response: UserSearchResponse)

    fun onGetUserSearchFailure(message: String)
}