package com.padcx.mmz.happyfooddeliveryapp.network.auth

import com.padcx.mmz.happyfooddeliveryapp.data.vos.UserVO

/**
 * Created by Myint Myint Zaw on 11/2/2020.
 */
interface AuthManager {
    fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
    fun register(username: String, email: String, password: String, phone: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)

    fun getUserData(onSuccess: (userVO : UserVO) -> Unit, onFailure: (String) -> Unit)
    fun updateProfile(photoUrl: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
}