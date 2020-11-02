package com.padcx.mmz.shared.presenter

import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.shared.views.BaseView


interface BasePresenter<T: BaseView> {
    fun initPresenter(view:T)
    fun onUiReady(owner: LifecycleOwner)
}