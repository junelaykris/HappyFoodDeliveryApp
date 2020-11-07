package com.padcx.mmz.happyfooddeliveryapp.mvp.presenters

import com.padcx.mmz.happyfooddeliveryapp.delegates.CategoryItemActionDelegate
import com.padcx.mmz.happyfooddeliveryapp.delegates.PopularViewItemActionDelegate
import com.padcx.mmz.happyfooddeliveryapp.delegates.RestaurantItemActionDelegate
import com.padcx.mmz.happyfooddeliveryapp.mvp.views.HomeView
import com.padcx.mmz.shared.presenter.BasePresenter

/**
 * Created by Myint Myint Zaw on 11/2/2020.
 */
interface HomePresenter: BasePresenter<HomeView>, RestaurantItemActionDelegate,CategoryItemActionDelegate,
        PopularViewItemActionDelegate {
}