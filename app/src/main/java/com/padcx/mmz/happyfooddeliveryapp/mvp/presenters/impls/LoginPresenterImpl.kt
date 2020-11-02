package com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.impls

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.happyfooddeliveryapp.data.models.AuthenticationModel
import com.padcx.mmz.happyfooddeliveryapp.data.models.AuthenticationModelImpl
import com.padcx.mmz.happyfooddeliveryapp.data.models.FoodDeliveryModel
import com.padcx.mmz.happyfooddeliveryapp.data.models.FoodDeliveryModelImpl
import com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.LoginPresenter
import com.padcx.mmz.happyfooddeliveryapp.mvp.views.LoginView
import com.padcx.mmz.shared.presenter.AbstractBasePresenter

/**
 * Created by Myint Myint Zaw on 11/2/2020.
 */
class LoginPresenterImpl: LoginPresenter, AbstractBasePresenter<LoginView>() {

    private val mAuthenticationModel: AuthenticationModel = AuthenticationModelImpl
    private  val mFoodDeliveryModel : FoodDeliveryModel = FoodDeliveryModelImpl

    override fun onTapLogin(email: String, password: String) {
        mAuthenticationModel.login(email, password, onSuccess = {
            mView?.navigateToHomeScreen()
        }, onFailure = {
            mView?.showError(it)
        })
    }

    override fun onTapRegister() {
        mView?.navigateToRegisterScreen()
    }

    override fun onUiReady(owner: LifecycleOwner) {
        Log.e("Firebase","remote config is ready...")
        mFoodDeliveryModel.setUpRemoteConfigWithDefaultValues()
        mFoodDeliveryModel.fetchRemoteConfigs()
    }

}