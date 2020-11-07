package com.padcx.mmz.happyfooddeliveryapp.data.models

import android.graphics.Bitmap
import com.padcx.mmz.happyfooddeliveryapp.data.vos.CategoryVO
import com.padcx.mmz.happyfooddeliveryapp.data.vos.FoodItemVO
import com.padcx.mmz.happyfooddeliveryapp.data.vos.RestaurantVO
import com.padcx.mmz.happyfooddeliveryapp.network.FirebaseApi
import com.padcx.mmz.happyfooddeliveryapp.network.remoteconfig.FirebaseRemoteConfigManager

interface FoodDeliveryModel {

    var mFirebaseApi : FirebaseApi

    var mFirebaseRemoteConfigManager : FirebaseRemoteConfigManager

    fun setUpRemoteConfigWithDefaultValues()

    fun fetchRemoteConfigs()

    fun getHomeScreenTypeStatusFromRemoteConfig() : Int

    fun getRestaurants(onSuccess: (List<RestaurantVO>) -> Unit, onFailure: (String) -> Unit)

    fun getCategories(onSuccess: (List<CategoryVO>) -> Unit, onFailure: (String) -> Unit)

    fun getPopularChoiceList(onSuccess: (List<FoodItemVO>) -> Unit, onFailure: (String) -> Unit)

    fun getFoodItems(documentId: String, onSuccess: (List<FoodItemVO>,RestaurantVO) -> Unit, onFailure: (String) -> Unit)

    fun updateCartFoodItem(foodItemVO: FoodItemVO)

    fun getCartItemCount(onSuccess: (cartCount: Long) -> Unit, onFailure: (String) -> Unit)

    fun getOrderList(onSuccess: (List<FoodItemVO>) -> Unit, onFailure: (String) -> Unit)

    fun removeFoodItem(name: String)

    fun getTotalPrice(onSuccess: (cartCount: Long) -> Unit, onFailure: (String) -> Unit)

    fun uploadPhotoToFirebaseStorage( image : Bitmap , onSuccess: (photoUrl : String) -> Unit, onFailure: (String) -> Unit)

}