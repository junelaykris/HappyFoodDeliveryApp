package com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.happyfooddeliveryapp.data.models.FoodDeliveryModel
import com.padcx.mmz.happyfooddeliveryapp.data.models.FoodDeliveryModelImpl
import com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.HomePresenter
import com.padcx.mmz.happyfooddeliveryapp.mvp.views.HomeView
import com.padcx.mmz.shared.presenter.AbstractBasePresenter

/**
 * Created by Myint Myint Zaw on 11/2/2020.
 */
class HomePresenterImpl : HomePresenter, AbstractBasePresenter<HomeView>() {

    private val foodDeliveryModel: FoodDeliveryModel = FoodDeliveryModelImpl

    override fun onUiReady(owner: LifecycleOwner) {
        mView?.changeHomeScreenViewType(foodDeliveryModel.getHomeScreenTypeStatusFromRemoteConfig())

        foodDeliveryModel.getRestaurants(
                onSuccess = {
                    mView?.showRestaurants(it)
                },
                onFailure = {
                    mView?.showErrorMessage(it)
                })

        foodDeliveryModel.getCategories(
                onSuccess = {
                    mView?.showCategories(it)
                },
                onFailure = {
                    mView?.showErrorMessage(it)
                })


        foodDeliveryModel.getPopularChoiceList(
                onSuccess = {
                    mView?.showPopularChoicesFoodItems(it)
                },
                onFailure = {
                mView?.showErrorMessage(it)
        })
    }

    override fun onTapRestaurantsListItem(restaurantId: String) {
        mView?.navigateToDetailScreen(restaurantId)
    }

    override fun onTapCategoryItem(categoryId: String) {

    }

    override fun onTapPopularChoiceListItem() {

    }
}