package com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.happyfooddeliveryapp.data.models.FoodDeliveryModel
import com.padcx.mmz.happyfooddeliveryapp.data.models.FoodDeliveryModelImpl
import com.padcx.mmz.happyfooddeliveryapp.data.vos.FoodItemVO
import com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.CartCheckoutPresenter
import com.padcx.mmz.happyfooddeliveryapp.mvp.views.CartCheckOutView
import com.padcx.mmz.shared.presenter.AbstractBasePresenter

/**
 * Created by Myint Myint Zaw on 11/4/2020.
 */
class CartCheckoutPresenterImpl : CartCheckoutPresenter, AbstractBasePresenter<CartCheckOutView>() {

    private val foodDeliveryModel : FoodDeliveryModel = FoodDeliveryModelImpl

    override fun onTapCheckoutItems(orderList: List<FoodItemVO>) {
        for(order in orderList) {
            foodDeliveryModel.removeFoodItem(order.food_name.toString())
        }
    }

    override fun onUiReady(owner: LifecycleOwner) {
        foodDeliveryModel.getOrderList(
                onSuccess = {
                    mView?.showOrdersList(it)
                    calculateItemPrice()
                },
                onFailure = {
                    mView?.showError(it)
                })
    }

    override fun onTapIncreaseCartItem(foodItemVO: FoodItemVO) {
        var itemCount = foodItemVO.itemCount.toLong()
        var itemPrice = foodItemVO.food_price.toLong()
        if(itemCount>0)
        {
            itemCount++
        }
        foodItemVO.itemCount= itemCount
        var totalAmount= itemCount * itemPrice
        foodItemVO.totalAmount= totalAmount

        foodDeliveryModel.updateCartFoodItem(foodItemVO)

        calculateItemPrice()
    }

    override fun onTapDecreaseCartItem(foodItemVO: FoodItemVO) {
        var itemCount = foodItemVO.itemCount.toLong()
        var itemPrice = foodItemVO.food_price.toLong()
        if(itemCount>1)
        {
            itemCount--
        }
        foodItemVO.itemCount= itemCount
        var totalAmount= itemCount * itemPrice
        foodItemVO.totalAmount= totalAmount
        foodDeliveryModel.updateCartFoodItem(foodItemVO)
        calculateItemPrice()
    }

    override fun onTapRemoveCartItem(foodItemVO: FoodItemVO) {
        foodDeliveryModel.removeFoodItem(foodItemVO?.food_name.toString())
        calculateItemPrice()
    }


    private fun calculateItemPrice() {
        foodDeliveryModel.getTotalPrice(
                onSuccess = {
                    mView?.showCalculationTotalCharge(it)
                },
                onFailure = {
                    mView?.showError(it)
                }
        )
    }

}