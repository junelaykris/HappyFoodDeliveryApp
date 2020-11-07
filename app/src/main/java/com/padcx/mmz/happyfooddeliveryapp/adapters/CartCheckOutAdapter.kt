package com.padcx.mmz.happyfooddeliveryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.mmz.happyfooddeliveryapp.R
import com.padcx.mmz.happyfooddeliveryapp.data.vos.FoodItemVO
import com.padcx.mmz.happyfooddeliveryapp.delegates.CheckoutViewItemActionDelegate
import com.padcx.mmz.happyfooddeliveryapp.viewholders.CheckoutViewHolder
import com.padcx.mmz.shared.adapter.BaseRecyclerAdapter

/**
 * Created by Myint Myint Zaw on 11/4/2020.
 */
class CartCheckOutAdapter(private val mDelegate: CheckoutViewItemActionDelegate) :
        BaseRecyclerAdapter<CheckoutViewHolder, FoodItemVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckoutViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.cart_checkout_item, parent, false)
        return CheckoutViewHolder(view, mDelegate)

    }
}