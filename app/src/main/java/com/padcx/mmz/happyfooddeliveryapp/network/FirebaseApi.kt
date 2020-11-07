package com.padcx.mmz.happyfooddeliveryapp.network

import android.graphics.Bitmap
import com.padcx.mmz.happyfooddeliveryapp.data.vos.CategoryVO
import com.padcx.mmz.happyfooddeliveryapp.data.vos.FoodItemVO
import com.padcx.mmz.happyfooddeliveryapp.data.vos.RestaurantVO

interface FirebaseApi {

    fun getCategories(onSuccess: (categories: List<CategoryVO>) -> Unit, onFailure: (String) -> Unit)
    fun getRestaurants(onSuccess: (restaurants: List<RestaurantVO>) -> Unit, onFailure: (String) -> Unit)
    fun getPopularChoiceList(onSuccess: (restaurants: List<FoodItemVO>) -> Unit, onFailure: (String) -> Unit)

    fun getFoodItems(documentId: String, onSuccess: (foodList: List<FoodItemVO>, restaurantVO: RestaurantVO) -> Unit, onFailure: (String) -> Unit)
    fun addToCartItem(foodItemVO: FoodItemVO)

    fun getCartItemCount(onSuccess: (cartCount: Long) -> Unit, onFailure: (String) -> Unit)

    fun getOrderList(onSuccess: (restaurants: List<FoodItemVO>) -> Unit, onFailure: (String) -> Unit)

    fun deleteFoodItem(id: String)

    fun getTotalPrice(onSuccess: (cartCount: Long) -> Unit, onFailure: (String) -> Unit)

    fun uploadPhotoToFirebaseStorage(image : Bitmap, onSuccess: (photoUrl : String) -> Unit, onFailure: (String) -> Unit)

    /* fun getFoodItems( documentId: String, onSuccess: (foodList: List<FoodItemVO>, restaurantVO : RestaurantVO) -> Unit, onFialure: (String) -> Unit)

     fun getOrderList(onSuccess: (restaurants: List<FoodItemVO>) -> Unit, onFialure: (String) -> Unit)
     fun addOrUpdateFoodItem(foodItemVO: FoodItemVO)
     fun deleteFoodItem(id: String)
     fun getCartItemCount(onSuccess: (cartCount: Long) -> Unit, onFialure: (String) -> Unit)
     fun getTotalPrice(onSuccess: (cartCount: Long) -> Unit, onFialure: (String) -> Unit)*/
}