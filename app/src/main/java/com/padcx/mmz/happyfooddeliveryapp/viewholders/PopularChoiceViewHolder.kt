package com.padcx.mmz.happyfooddeliveryapp.viewholders

import android.view.View
import com.padcx.mmz.happyfooddeliveryapp.data.vos.FoodItemVO
import com.padcx.mmz.happyfooddeliveryapp.delegates.PopularViewItemActionDelegate
import com.padcx.mmz.happyfooddeliveryapp.utils.load
import com.padcx.mmz.shared.views.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.horizontal_restaurant_view.view.*
import kotlinx.android.synthetic.main.popularchoice_item.view.*
import kotlinx.android.synthetic.main.popularchoice_item.view.tv_restaurant_name

/**
 * Created by Myint Myint Zaw on 11/2/2020.
 */
class PopularChoiceViewHolder(itemView: View, private val mDelegate: PopularViewItemActionDelegate) :
        BaseViewHolder<FoodItemVO>(itemView) {

    override fun bindData(data: FoodItemVO) {
        data?.let {
            itemView.tv_restaurant_name.text =data.food_name
            itemView.tv_food_description.text =data.food_description
            itemView.tv_food_rating.text =data.food_rating
            data.food_image?.let{
                itemView.iv_food_item.load(data.food_image)
            }
        }
    }
}