package com.padcx.mmz.happyfooddeliveryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.mmz.happyfooddeliveryapp.R
import com.padcx.mmz.happyfooddeliveryapp.data.vos.RestaurantVO
import com.padcx.mmz.happyfooddeliveryapp.delegates.RestaurantItemActionDelegate
import com.padcx.mmz.happyfooddeliveryapp.viewholders.RestaurantsViewHolder
import com.padcx.mmz.shared.adapter.BaseRecyclerAdapter

/**
 * Created by Myint Myint Zaw on 11/2/2020.
 */
class RestaurantAdapter (private val mDelegate: RestaurantItemActionDelegate, private val viewscreenType: Int) :
        BaseRecyclerAdapter<RestaurantsViewHolder, RestaurantVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsViewHolder {
        return when (viewscreenType) {
            0 -> {
                val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.horizontal_restaurant_view, parent, false)
                RestaurantsViewHolder(view, mDelegate)
            }

            else -> {
                val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.vertical_restaurant_view, parent, false)
                RestaurantsViewHolder(view, mDelegate)
            }
        }
    }
}