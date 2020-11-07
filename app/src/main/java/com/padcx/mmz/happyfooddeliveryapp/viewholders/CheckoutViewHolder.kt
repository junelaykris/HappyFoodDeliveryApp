package com.padcx.mmz.happyfooddeliveryapp.viewholders

import android.view.View
import com.padcx.mmz.happyfooddeliveryapp.data.vos.FoodItemVO
import com.padcx.mmz.happyfooddeliveryapp.delegates.CheckoutViewItemActionDelegate
import com.padcx.mmz.happyfooddeliveryapp.utils.load
import com.padcx.mmz.shared.views.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.cart_checkout_item.view.*


/**
 * Created by Myint Myint Zaw on 11/2/2020.
 */
class CheckoutViewHolder(itemView: View, private val mDelegate: CheckoutViewItemActionDelegate) :
        BaseViewHolder<FoodItemVO>(itemView) {

    override fun bindData(data: FoodItemVO) {

        data?.let {
            itemView.tv_restaurant_name.text =data?.food_name
            itemView.tv_restaurant_description.text = data?.food_description
            itemView.tv_restaurant_rating.text =data?.food_rating
            itemView.tv_restaurant_price.text =data?.food_price.toString()
            itemView.tv_totalamount.text = "Total  ${data?.totalAmount} "
            itemView.tv_itemCount.text =" * ${data?.itemCount}"
            data?.food_image?.let{
                itemView.img_restaurant.load(it)
            }
            itemView.btn_plus.setOnClickListener{
                mDelegate.onTapIncreaseCartItem(data)
            }
            itemView.btn_minus.setOnClickListener{
                mDelegate.onTapDecreaseCartItem(data)
            }
            itemView.btn_delete.setOnClickListener{
                mDelegate.onTapRemoveCartItem(data)
            }
        }
    }
}