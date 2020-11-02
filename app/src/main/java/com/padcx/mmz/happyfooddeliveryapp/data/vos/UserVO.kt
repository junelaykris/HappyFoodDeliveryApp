package com.padcx.mmz.happyfooddeliveryapp.data.vos

import com.google.firebase.firestore.IgnoreExtraProperties


@IgnoreExtraProperties
class UserVO(
    var name: String? = "",
    var email: String? = "",
    var password: String? = "",
    var phone: String? = "",
    var photoUrl : String?= ""
)