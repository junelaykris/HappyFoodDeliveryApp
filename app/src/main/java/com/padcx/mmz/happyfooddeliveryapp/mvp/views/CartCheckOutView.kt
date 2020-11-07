package com.padcx.mmz.happyfooddeliveryapp.mvp.views

import com.padcx.mmz.happyfooddeliveryapp.data.vos.FoodItemVO
import com.padcx.mmz.shared.views.BaseView

/**
 * Created by Myint Myint Zaw on 11/4/2020.
 */
interface CartCheckOutView: BaseView {
    fun showOrdersList(orderList: List<FoodItemVO>)
    fun showCalculationTotalCharge(totalAmount: Long)
}