package com.padcx.mmz.happyfooddeliveryapp.mvp.presenters

import com.padcx.mmz.happyfooddeliveryapp.mvp.views.WelcomeView
import com.padcx.mmz.shared.presenter.BasePresenter

/**
 * Created by Myint Myint Zaw on 11/1/2020.
 */
interface WelcomePresenter : BasePresenter<WelcomeView>{
    fun onTapStarted()
}
