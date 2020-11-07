package com.padcx.mmz.happyfooddeliveryapp.delegates

import com.padcx.mmz.happyfooddeliveryapp.data.vos.FoodItemVO

/**
 * Created by Myint Myint Zaw on 11/4/2020.
 */
interface DetailViewItemActionDelegate {
    fun onTapAddToCartItem(data: FoodItemVO)
}