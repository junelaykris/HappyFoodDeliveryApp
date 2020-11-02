package com.padcx.mmz.happyfooddeliveryapp.mvp.views

import com.padcx.mmz.shared.views.BaseView

interface LoginView : BaseView {
    fun navigateToHomeScreen()
    fun navigateToRegisterScreen()
}