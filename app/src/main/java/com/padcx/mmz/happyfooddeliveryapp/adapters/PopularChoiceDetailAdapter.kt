package com.padcx.mmz.happyfooddeliveryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.mmz.happyfooddeliveryapp.R
import com.padcx.mmz.happyfooddeliveryapp.data.vos.FoodItemVO
import com.padcx.mmz.happyfooddeliveryapp.delegates.PopularViewItemActionDelegate
import com.padcx.mmz.happyfooddeliveryapp.viewholders.PopularChoiceDetailViewHolder
import com.padcx.mmz.happyfooddeliveryapp.viewholders.PopularChoiceViewHolder
import com.padcx.mmz.shared.adapter.BaseRecyclerAdapter

/**
 * Created by Myint Myint Zaw on 11/2/2020.
 */
class PopularChoiceDetailAdapter () :
        BaseRecyclerAdapter<PopularChoiceDetailViewHolder, FoodItemVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularChoiceDetailViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.popular_choice_detail_layout, parent, false)
        return PopularChoiceDetailViewHolder(view)

    }
}
