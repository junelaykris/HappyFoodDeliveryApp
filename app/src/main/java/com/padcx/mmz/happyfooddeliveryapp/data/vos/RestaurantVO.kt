package com.padcx.mmz.happyfooddeliveryapp.data.vos

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
class RestaurantVO(
        var id: String?= "",
        var description: String? = "",
        var image_url: String? = "",
        var name: String? = "",
        var rating: String? = ""
)