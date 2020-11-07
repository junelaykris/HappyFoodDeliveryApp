package com.padcx.mmz.happyfooddeliveryapp.utils

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.padcx.mmz.happyfooddeliveryapp.R
import java.util.*

/**
 * Created by Myint Myint Zaw on 9/5/2020.
 */

fun ImageView.load(url: String?) {
    Glide.with(context)?.load(url)
            .placeholder(R.drawable.fooddelivery)
            .error(R.drawable.fooddelivery)
            .into(this)

}



fun ImageView.showCropImage(context: Context, imageView: ImageView, imageUrl: String?, filePath: Uri?) {
    Glide.with(context)
            .asBitmap()
            .load(filePath ?: imageUrl)
            .placeholder(R.drawable.fooddelivery)
            .apply(RequestOptions().circleCrop())
            .into(imageView)
}




