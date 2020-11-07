package com.padcx.mmz.happyfooddeliveryapp.data.models

import com.padcx.mmz.happyfooddeliveryapp.data.vos.UserVO
import com.padcx.mmz.happyfooddeliveryapp.network.auth.AuthManager

/**
 * Created by Myint Myint Zaw on 11/2/2020.
 */
interface AuthenticationModel {
    var mAuthManager: AuthManager

    fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)

    fun register(
        username: String,
        email: String,
        password: String,
        phone: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )

    fun userData(
            onSuccess: (userVO : UserVO) -> Unit,
            onFailure: (String) -> Unit
    )

    fun updateProfile(
            photoUrl: String,
            onSuccess: () -> Unit,
            onFailure: (String) -> Unit
    )
}