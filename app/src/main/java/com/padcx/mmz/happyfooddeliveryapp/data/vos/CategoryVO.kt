package com.padcx.mmz.happyfooddeliveryapp.data.vos

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
class CategoryVO(
        var category_id: String?= "",
        var category_name: String? = "",
        var category_image: String? = ""
)