package com.padcx.mmz.happyfooddeliveryapp.viewholders

import android.view.View
import com.padcx.mmz.happyfooddeliveryapp.data.vos.FoodItemVO
import com.padcx.mmz.happyfooddeliveryapp.utils.load
import com.padcx.mmz.shared.views.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.popular_choice_detail_layout.view.*

/**
 * Created by Myint Myint Zaw on 11/4/2020.
 */
class PopularChoiceDetailViewHolder (itemView: View) :
        BaseViewHolder<FoodItemVO>(itemView) {

    override fun bindData(data: FoodItemVO) {
        data?.let {
            itemView.tv_detail_popularchoice_name.text =data?.food_name
            itemView.tv_detail_popularchoice_price.text =data?.food_price.toString()+" Ks"
            data?.food_image?.let{
                itemView.img_detail_popularchoice.load(it)
            }
        }
    }
}