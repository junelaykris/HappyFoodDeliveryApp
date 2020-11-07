package com.padcx.mmz.happyfooddeliveryapp.viewholders

import android.view.View
import com.padcx.mmz.happyfooddeliveryapp.data.vos.CategoryVO
import com.padcx.mmz.happyfooddeliveryapp.delegates.CategoryItemActionDelegate
import com.padcx.mmz.happyfooddeliveryapp.utils.load
import com.padcx.mmz.shared.views.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.category_item.view.*

/**
 * Created by Myint Myint Zaw on 11/2/2020.
 */
class CategoryViewHolder(itemView: View, mDelegate: CategoryItemActionDelegate) :
        BaseViewHolder<CategoryVO>(itemView) {

    override fun bindData(data: CategoryVO) {

        data?.let {
            itemView.tv_category.text =data.category_name
            data.category_image?.let {
                itemView.img_category.load(data.category_image)
            }
        }
    }
}