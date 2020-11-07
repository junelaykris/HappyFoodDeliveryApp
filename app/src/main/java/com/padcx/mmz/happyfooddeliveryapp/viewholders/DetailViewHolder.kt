package com.padcx.mmz.happyfooddeliveryapp.viewholders

import android.view.View
import com.padcx.mmz.happyfooddeliveryapp.data.vos.FoodItemVO
import com.padcx.mmz.happyfooddeliveryapp.delegates.DetailViewItemActionDelegate
import com.padcx.mmz.happyfooddeliveryapp.utils.load
import com.padcx.mmz.shared.views.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.restaurant_detail_fooditem_layout.view.*

/**
 * Created by Myint Myint Zaw on 11/2/2020.
 */
class DetailViewHolder(itemView: View, private val mDelegate: DetailViewItemActionDelegate) :
        BaseViewHolder<FoodItemVO>(itemView) {

    override fun bindData(data: FoodItemVO) {

        data?.let {
            itemView.tv_restaurant_name.text =data?.food_name
            itemView.tv_restaurant_description.text = data?.food_description
            itemView.tv_restaurant_rating.text =data?.food_rating
            itemView.tv_restaurant_price.text =data?.food_price.toString()+" Ks"
            data?.food_image?.let{
                itemView.img_restaurant.load(it)
            }
            itemView.btn_plus.setOnClickListener{
                mDelegate.onTapAddToCartItem(data)
            }
        }
    }
}