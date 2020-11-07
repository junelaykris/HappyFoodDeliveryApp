package com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.happyfooddeliveryapp.data.models.FoodDeliveryModel
import com.padcx.mmz.happyfooddeliveryapp.data.models.FoodDeliveryModelImpl
import com.padcx.mmz.happyfooddeliveryapp.data.vos.FoodItemVO
import com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.DetailPresenter
import com.padcx.mmz.happyfooddeliveryapp.mvp.views.DetailView
import com.padcx.mmz.shared.presenter.AbstractBasePresenter

/**
 * Created by Myint Myint Zaw on 11/4/2020.
 */
class DetailPresenterImpl : DetailPresenter, AbstractBasePresenter<DetailView>() {
    private val foodDeliveryModel: FoodDeliveryModel = FoodDeliveryModelImpl

    override fun onFetchRestaurantDetailData(lifecycleOwner: LifecycleOwner, documentId: String) {
        foodDeliveryModel.getFoodItems(
                documentId,
                onSuccess = { dataList, restaurant ->
                    mView?.showPopularChoicesFoodItem(
                            dataList.filter { data ->
                                data.popular
                            }
                    )
                    mView?.showRestaurantData(restaurant)
                    mView?.showFoodItemList(dataList)
                },
                onFailure = {
                    mView?.showError(it)
                })
    }

    override fun onUiReady(owner: LifecycleOwner) {
        foodDeliveryModel.getCartItemCount(
                onSuccess = {
                    mView?.showViewCartCount(it)
                },
                onFailure = {
                    mView?.showError(it)
                })
    }

    override fun onTapAddToCartItem(data: FoodItemVO) {
        var totalAmount = data.itemCount * data.food_price
        data.totalAmount = totalAmount
        foodDeliveryModel.updateCartFoodItem(data)

        foodDeliveryModel.getCartItemCount(
                onSuccess = {
                    mView?.showViewCartCount(it)
                },
                onFailure = {
                    mView?.showError(it)
                })
    }
}