package com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.impls

import android.graphics.Bitmap
import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.happyfooddeliveryapp.data.models.AuthenticationModel
import com.padcx.mmz.happyfooddeliveryapp.data.models.AuthenticationModelImpl
import com.padcx.mmz.happyfooddeliveryapp.data.models.FoodDeliveryModel
import com.padcx.mmz.happyfooddeliveryapp.data.models.FoodDeliveryModelImpl
import com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.ProfilePresenter
import com.padcx.mmz.happyfooddeliveryapp.mvp.views.ProfileView
import com.padcx.mmz.shared.presenter.AbstractBasePresenter

/**
 * Created by Myint Myint Zaw on 11/4/2020.
 */
class ProfilePresenterImpl: ProfilePresenter, AbstractBasePresenter<ProfileView>() {

    private val mAuthenticationModel: AuthenticationModel = AuthenticationModelImpl

    private  val foodDeliveryModel : FoodDeliveryModel = FoodDeliveryModelImpl

    override fun updateUserProfile(bitmap: Bitmap) {
        foodDeliveryModel.uploadPhotoToFirebaseStorage(bitmap,
                onSuccess = {
                    mView?.onTapSaveUserData()
                    mAuthenticationModel.updateProfile(it,onSuccess = {}) {}
                },
                onFailure = {
                    mView?.showError("Profile Update Failed")
                })

    }

    override fun onTapCancelUserData() {
        mView?.onTapCancelUserData()
    }

    override fun onTapChangeProfileImage() {
        mView?.onTapEditProfileImage()
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mAuthenticationModel?.userData(
                onSuccess = {
                    mView?.displayUserData(it)
                },
                onFailure = {}
        )
    }
}