package com.padcx.mmz.happyfooddeliveryapp.fragments

import android.app.Activity
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.padcx.mmz.happyfooddeliveryapp.R
import com.padcx.mmz.happyfooddeliveryapp.data.vos.UserVO
import com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.ProfilePresenter
import com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.impls.ProfilePresenterImpl
import com.padcx.mmz.happyfooddeliveryapp.mvp.views.ProfileView
import com.padcx.mmz.happyfooddeliveryapp.utils.load
import com.padcx.mmz.happyfooddeliveryapp.utils.showCropImage
import com.padcx.mmz.shared.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_account.*
import java.io.File
import java.io.IOException

/**
 * Created by Myint Myint Zaw on 11/2/2020.
 */
class AccountFragment: BaseFragment(),ProfileView {

    private lateinit var mPresenter: ProfilePresenter
    private var bitmap: Bitmap? = null

    private var username: String? = null

    companion object {
        const val PICK_IMAGE_REQUEST = 1111
        lateinit var mContext: Context
        fun newInstance(context: Context): AccountFragment {
            mContext = context
            return AccountFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_account, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpActionListener()
    }

    private fun setUpActionListener() {
        img_edit.setOnClickListener {
            mPresenter?.onTapChangeProfileImage()
        }
        tv_save.setOnClickListener {
            bitmap?.let { mPresenter.updateUserProfile(it) }
        }
        tv_cancel.setOnClickListener {
            bitmap?.let {
                mPresenter.onTapCancelUserData()
            }
        }
    }

    private fun setUpPresenter() {
        activity?.let {
            mPresenter = getPresenter<ProfilePresenterImpl, ProfileView>()
            mPresenter.onUiReady(this)
        }
    }

    override fun onTapSaveUserData() {
        account_btngroup.visibility = View.GONE
    }

    override fun onTapCancelUserData() {
        account_btngroup.visibility = View.GONE
    }

    override fun onTapEditProfileImage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(
            Intent.createChooser(intent, "Select Picture"),
            AccountFragment.PICK_IMAGE_REQUEST
        )
    }

    override fun displayUserData(userVO: UserVO) {
        etUserName.text = Editable.Factory.getInstance().newEditable(userVO.name)
        etEmail.text = Editable.Factory.getInstance().newEditable(userVO.email)
        etPassword.text = Editable.Factory.getInstance().newEditable(userVO.password)
        etPhone.text = Editable.Factory.getInstance().newEditable(userVO.phone)
        img_profile.load(userVO.photoUrl)

        //username = etUserName.text.toString()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            if (data == null || data.data == null) {
                return
            }
            val filePath = data.data
            try {
                val file = File(filePath?.path!!)
                filePath?.let {
                    bitmap = activity?.contentResolver?.let { it1 -> getBitmap(it, file, it1) }
                }
                img_profile.showCropImage(img_profile.context, img_profile, null, filePath)

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun getBitmap(
        selectedPhotoUri: Uri,
        file: File,
        contentResolver: ContentResolver
    ): Bitmap? {
        try {
            selectedPhotoUri?.let {
                if (Build.VERSION.SDK_INT < 28) {
                    account_btngroup.visibility = View.VISIBLE
                    return MediaStore.Images.Media.getBitmap(
                        contentResolver,
                        selectedPhotoUri
                    )

                } else {
                    account_btngroup.visibility = View.GONE
                    val source = ImageDecoder.createSource(file)
                    return ImageDecoder.decodeBitmap(source)


                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }
}