package com.padcx.mmz.happyfooddeliveryapp.mvp.presenters

import android.graphics.Bitmap
import com.padcx.mmz.happyfooddeliveryapp.mvp.views.ProfileView
import com.padcx.mmz.shared.presenter.BasePresenter

/**
 * Created by Myint Myint Zaw on 11/4/2020.
 */
interface ProfilePresenter : BasePresenter<ProfileView> {
    fun updateUserProfile(bitmap: Bitmap)
    fun onTapCancelUserData()
    fun onTapChangeProfileImage()
}