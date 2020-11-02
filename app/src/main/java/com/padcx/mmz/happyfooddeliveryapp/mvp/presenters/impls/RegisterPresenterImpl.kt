package com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.happyfooddeliveryapp.data.models.AuthenticationModel
import com.padcx.mmz.happyfooddeliveryapp.data.models.AuthenticationModelImpl
import com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.RegisterPresenter
import com.padcx.mmz.happyfooddeliveryapp.mvp.views.RegisterView
import com.padcx.mmz.shared.presenter.AbstractBasePresenter

/**
 * Created by Myint Myint Zaw on 11/2/2020.
 */
class RegisterPresenterImpl:RegisterPresenter, AbstractBasePresenter<RegisterView>() {

    private val mAuthenticationModel: AuthenticationModel = AuthenticationModelImpl

    override fun onTapRegister(userName: String, email: String, password: String, phone: String) {
        mAuthenticationModel.register(userName, email, password,phone, onSuccess = {
            mView?.navigateToToLoginScreen()
        }, onFailure = {
            mView?.showError(it)
        })
    }

    override fun navigateToLoginScreen() {
        mView?.navigateToToLoginScreen()
    }

    override fun onUiReady(owner: LifecycleOwner) {
    }
}