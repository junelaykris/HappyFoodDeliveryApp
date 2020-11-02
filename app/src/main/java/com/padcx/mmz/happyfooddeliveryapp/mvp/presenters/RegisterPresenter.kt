package com.padcx.mmz.happyfooddeliveryapp.mvp.presenters

import com.padcx.mmz.happyfooddeliveryapp.mvp.views.RegisterView
import com.padcx.mmz.happyfooddeliveryapp.mvp.views.WelcomeView
import com.padcx.mmz.shared.presenter.BasePresenter

/**
 * Created by Myint Myint Zaw on 11/1/2020.
 */
interface RegisterPresenter : BasePresenter<RegisterView>{
    fun onTapRegister(username: String, email: String, password: String,phone : String)
    fun navigateToLoginScreen()
}
