package com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.WelcomePresenter
import com.padcx.mmz.happyfooddeliveryapp.mvp.views.WelcomeView
import com.padcx.mmz.shared.presenter.AbstractBasePresenter

/**
 * Created by Myint Myint Zaw on 11/1/2020.
 */
class WelcomePresenterImpl:WelcomePresenter,AbstractBasePresenter<WelcomeView>() {
    override fun onTapStarted() {
        mView?.navigateToLoginScreen()
    }

    override fun onUiReady(owner: LifecycleOwner) {
    }

}