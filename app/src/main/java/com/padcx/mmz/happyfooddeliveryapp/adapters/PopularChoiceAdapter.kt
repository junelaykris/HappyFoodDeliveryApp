package com.padcx.mmz.happyfooddeliveryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.mmz.happyfooddeliveryapp.R
import com.padcx.mmz.happyfooddeliveryapp.data.vos.FoodItemVO
import com.padcx.mmz.happyfooddeliveryapp.delegates.PopularViewItemActionDelegate
import com.padcx.mmz.happyfooddeliveryapp.viewholders.PopularChoiceViewHolder
import com.padcx.mmz.shared.adapter.BaseRecyclerAdapter

/**
 * Created by Myint Myint Zaw on 11/2/2020.
 */
class PopularChoiceAdapter (private val mDelegate: PopularViewItemActionDelegate) :
        BaseRecyclerAdapter<PopularChoiceViewHolder, FoodItemVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularChoiceViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.popularchoice_item, parent, false)
        return PopularChoiceViewHolder(view, mDelegate)

    }
}
