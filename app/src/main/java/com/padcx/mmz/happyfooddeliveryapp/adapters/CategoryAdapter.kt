package com.padcx.mmz.happyfooddeliveryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.mmz.happyfooddeliveryapp.R
import com.padcx.mmz.happyfooddeliveryapp.data.vos.CategoryVO
import com.padcx.mmz.happyfooddeliveryapp.delegates.CategoryItemActionDelegate
import com.padcx.mmz.happyfooddeliveryapp.viewholders.CategoryViewHolder
import com.padcx.mmz.shared.adapter.BaseRecyclerAdapter

/**
 * Created by Myint Myint Zaw on 11/2/2020.
 */
class CategoryAdapter (private val mDelegate: CategoryItemActionDelegate) :
        BaseRecyclerAdapter<CategoryViewHolder, CategoryVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.category_item, parent, false)
        return CategoryViewHolder(view, mDelegate)

    }
}