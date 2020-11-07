package com.padcx.mmz.happyfooddeliveryapp.data.models

import android.graphics.Bitmap
import com.example.fooddeliveryapp.network.impls.CloudFirestoreFirebaseApiImpl
import com.padcx.mmz.happyfooddeliveryapp.data.vos.CategoryVO
import com.padcx.mmz.happyfooddeliveryapp.data.vos.FoodItemVO
import com.padcx.mmz.happyfooddeliveryapp.data.vos.RestaurantVO
import com.padcx.mmz.happyfooddeliveryapp.network.FirebaseApi
import com.padcx.mmz.happyfooddeliveryapp.network.remoteconfig.FirebaseRemoteConfigManager


object FoodDeliveryModelImpl : FoodDeliveryModel {

    override var mFirebaseApi: FirebaseApi = CloudFirestoreFirebaseApiImpl

    override  var mFirebaseRemoteConfigManager: FirebaseRemoteConfigManager = FirebaseRemoteConfigManager

    override fun setUpRemoteConfigWithDefaultValues() {
        mFirebaseRemoteConfigManager.setUpRemoteConfigWithDeaultValues()
    }

    override fun fetchRemoteConfigs() {
        mFirebaseRemoteConfigManager.fetchRemoteConfigs()
    }

    override fun getHomeScreenTypeStatusFromRemoteConfig(): Int {
        return  mFirebaseRemoteConfigManager.getHomeScreenViewTypeStatus()
    }

    override fun getRestaurants(onSuccess: (List<RestaurantVO>) -> Unit, onFailure: (String) -> Unit) {
        mFirebaseApi.getRestaurants(onSuccess, onFailure)
    }

    override fun getCategories(onSuccess: (List<CategoryVO>) -> Unit, onFailure: (String) -> Unit) {
        mFirebaseApi.getCategories(onSuccess, onFailure)
    }

    override fun getPopularChoiceList(onSuccess: (List<FoodItemVO>) -> Unit, onFailure: (String) -> Unit) {
        mFirebaseApi.getPopularChoiceList(onSuccess, onFailure)
    }

    override fun getFoodItems(
            documentId: String,
            onSuccess: (List<FoodItemVO>,RestaurantVO) -> Unit,
            onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getFoodItems(documentId,onSuccess, onFailure)
    }

    override fun updateCartFoodItem(foodItemVO: FoodItemVO) {
        mFirebaseApi.addToCartItem(foodItemVO)
    }

    override fun getCartItemCount(onSuccess: (cartCount: Long) -> Unit, onFialure: (String) -> Unit) {
        mFirebaseApi.getCartItemCount(onSuccess,onFialure)
    }

    override fun getOrderList(onSuccess: (List<FoodItemVO>) -> Unit, onFaiure: (String) -> Unit) {
        mFirebaseApi.getOrderList(onSuccess, onFaiure)
    }

    override fun getTotalPrice(onSuccess: (cartCount: Long) -> Unit, onFialure: (String) -> Unit) {
        mFirebaseApi.getTotalPrice(onSuccess,onFialure)
    }

    override fun removeFoodItem(id: String) {
        mFirebaseApi.deleteFoodItem(id)
    }

    override fun uploadPhotoToFirebaseStorage(image: Bitmap , onSuccess: (photoUrl : String) -> Unit, onFailure: (String) -> Unit) {
        mFirebaseApi.uploadPhotoToFirebaseStorage(image ,onSuccess,onFailure)
    }
}