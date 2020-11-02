package com.padcx.mmz.happyfooddeliveryapp.data.models

import com.padcx.mmz.happyfooddeliveryapp.network.auth.AuthManager
import com.padcx.mmz.happyfooddeliveryapp.network.auth.FirebaseAuthManager

/**
 * Created by Myint Myint Zaw on 11/2/2020.
 */
object AuthenticationModelImpl: AuthenticationModel  {
    override var mAuthManager: AuthManager = FirebaseAuthManager

    override fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mAuthManager.login(email, password, onSuccess, onFailure)
    }

    override fun register(
        username: String,
        email: String,
        password: String,
        phone: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mAuthManager.register(username, email, password,phone, onSuccess, onFailure)
    }
}