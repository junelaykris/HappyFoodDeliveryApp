package com.padcx.mmz.happyfooddeliveryapp.mvp.views

import com.padcx.mmz.happyfooddeliveryapp.data.vos.FoodItemVO
import com.padcx.mmz.happyfooddeliveryapp.data.vos.RestaurantVO
import com.padcx.mmz.shared.views.BaseView

/**
 * Created by Myint Myint Zaw on 11/2/2020.
 */
interface DetailView :BaseView{
    fun showRestaurantData(restaurantVO: RestaurantVO)
    fun showPopularChoicesFoodItem(popularFoodList: List<FoodItemVO>)
    fun showFoodItemList(foodList: List<FoodItemVO>)
    fun showViewCartCount(cartCount : Long)
}