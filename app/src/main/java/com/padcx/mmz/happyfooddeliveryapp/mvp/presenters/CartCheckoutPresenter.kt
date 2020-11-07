package com.padcx.mmz.happyfooddeliveryapp.mvp.presenters

import com.padcx.mmz.happyfooddeliveryapp.data.vos.FoodItemVO
import com.padcx.mmz.happyfooddeliveryapp.delegates.CheckoutViewItemActionDelegate
import com.padcx.mmz.happyfooddeliveryapp.mvp.views.CartCheckOutView
import com.padcx.mmz.shared.presenter.BasePresenter

/**
 * Created by Myint Myint Zaw on 11/4/2020.
 */
interface CartCheckoutPresenter : BasePresenter<CartCheckOutView>, CheckoutViewItemActionDelegate {
    fun onTapCheckoutItems(orderList: List<FoodItemVO>)
}