package com.padcx.mmz.happyfooddeliveryapp.mvp.presenters

import com.padcx.mmz.happyfooddeliveryapp.mvp.views.LoginView
import com.padcx.mmz.shared.presenter.BasePresenter

interface LoginPresenter : BasePresenter<LoginView> {
    fun onTapLogin(email: String, password: String)
    fun onTapRegister()
}