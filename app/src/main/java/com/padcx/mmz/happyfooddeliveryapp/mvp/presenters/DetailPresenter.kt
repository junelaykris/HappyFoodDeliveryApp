package com.padcx.mmz.happyfooddeliveryapp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.happyfooddeliveryapp.delegates.DetailViewItemActionDelegate
import com.padcx.mmz.happyfooddeliveryapp.mvp.views.DetailView
import com.padcx.mmz.shared.presenter.BasePresenter

/**
 * Created by Myint Myint Zaw on 11/4/2020.
 */
interface DetailPresenter: BasePresenter<DetailView>,DetailViewItemActionDelegate{
    fun onFetchRestaurantDetailData(lifecycleOwner: LifecycleOwner, documentId : String)
}