package com.padcx.mmz.happyfooddeliveryapp.viewholders

import android.view.View
import com.padcx.mmz.happyfooddeliveryapp.data.vos.RestaurantVO
import com.padcx.mmz.happyfooddeliveryapp.delegates.RestaurantItemActionDelegate
import com.padcx.mmz.happyfooddeliveryapp.utils.load
import com.padcx.mmz.shared.views.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.category_item.view.*
import kotlinx.android.synthetic.main.horizontal_restaurant_view.view.*

/**
 * Created by Myint Myint Zaw on 11/2/2020.
 */
class RestaurantsViewHolder(itemView: View, private val mDelegate: RestaurantItemActionDelegate) :
        BaseViewHolder<RestaurantVO>(itemView) {

    override fun bindData(data: RestaurantVO) {
        data?.let {
            itemView.tv_restaurant_name.text = data?.name
            itemView.tv_restaurant_description.text = data?.description
            itemView.tv_restaurant_rating.text = data?.rating
            data.image_url?.let {
                itemView.iv_restaurant.load(data.image_url)
            }
        }
        itemView.setOnClickListener {
            data?.id.let { mDelegate.onTapRestaurantsListItem(it.toString()) }
        }

    }
}