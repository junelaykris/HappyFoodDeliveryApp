package com.padcx.mmz.happyfooddeliveryapp.data.vos

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
class FoodItemVO(
    var food_name: String?= "",
    var food_description: String? = "",
    var food_price: Long = 0,
    var food_rating: String? = "",
    var food_image: String? = "",
    var popular: Boolean = false,
    var most_popular: String?="",
    var itemCount: Long =1,
    var totalAmount: Long =0
)