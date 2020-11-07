package com.padcx.mmz.happyfooddeliveryapp.mvp.views

import com.padcx.mmz.happyfooddeliveryapp.data.vos.UserVO
import com.padcx.mmz.shared.views.BaseView

/**
 * Created by Myint Myint Zaw on 11/4/2020.
 */
interface ProfileView:BaseView {
    fun onTapSaveUserData()
    fun onTapCancelUserData()
    fun onTapEditProfileImage()
    fun displayUserData(userVO: UserVO)
}