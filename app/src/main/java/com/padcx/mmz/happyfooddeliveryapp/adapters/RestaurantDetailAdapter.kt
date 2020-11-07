package com.padcx.mmz.happyfooddeliveryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.mmz.happyfooddeliveryapp.R
import com.padcx.mmz.happyfooddeliveryapp.data.vos.FoodItemVO
import com.padcx.mmz.happyfooddeliveryapp.delegates.DetailViewItemActionDelegate
import com.padcx.mmz.happyfooddeliveryapp.viewholders.DetailViewHolder
import com.padcx.mmz.shared.adapter.BaseRecyclerAdapter

/**
 * Created by Myint Myint Zaw on 11/4/2020.
 */
class RestaurantDetailAdapter(private val mDelegate: DetailViewItemActionDelegate) :
        BaseRecyclerAdapter<DetailViewHolder, FoodItemVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.restaurant_detail_fooditem_layout, parent, false)
        return DetailViewHolder(view, mDelegate)

    }
}
