package com.padcx.mmz.happyfooddeliveryapp.mvp.views

import com.padcx.mmz.happyfooddeliveryapp.data.vos.CategoryVO
import com.padcx.mmz.happyfooddeliveryapp.data.vos.FoodItemVO
import com.padcx.mmz.happyfooddeliveryapp.data.vos.RestaurantVO
import com.padcx.mmz.shared.views.BaseView

interface HomeView : BaseView {
    fun changeHomeScreenViewType( viewType : Int)
    fun navigateToDetailScreen(documentId: String)
    fun showErrorMessage(message: String)
    fun showCategories(categoryList: List<CategoryVO>)
    fun showRestaurants(restaurantList: List<RestaurantVO>)
    fun showPopularChoicesFoodItems(popularChoiceList: List<FoodItemVO>)
}