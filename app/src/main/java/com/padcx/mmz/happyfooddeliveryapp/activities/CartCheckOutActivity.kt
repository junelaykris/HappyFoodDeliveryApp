package com.padcx.mmz.happyfooddeliveryapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.padcx.mmz.happyfooddeliveryapp.R
import com.padcx.mmz.happyfooddeliveryapp.adapters.CartCheckOutAdapter
import com.padcx.mmz.happyfooddeliveryapp.data.vos.FoodItemVO
import com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.CartCheckoutPresenter
import com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.impls.CartCheckoutPresenterImpl
import com.padcx.mmz.happyfooddeliveryapp.mvp.views.CartCheckOutView
import com.padcx.mmz.happyfooddeliveryapp.utils.load
import com.padcx.mmz.shared.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_checkout.*
import kotlinx.android.synthetic.main.checkout_success_dialog.view.*
import kotlinx.android.synthetic.main.restaurant_detail_fooditem_layout.*
import kotlinx.android.synthetic.main.restaurant_detail_fooditem_layout.img_restaurant
import kotlinx.android.synthetic.main.restaurant_detail_fooditem_layout.tv_restaurant_description
import kotlinx.android.synthetic.main.restaurant_detail_fooditem_layout.tv_restaurant_name
import kotlinx.android.synthetic.main.restaurant_detail_fooditem_layout.tv_restaurant_rating
import kotlinx.android.synthetic.main.vertical_restaurant_view.*

/**
 * Created by Myint Myint Zaw on 11/4/2020.
 */
class CartCheckOutActivity : BaseActivity(), CartCheckOutView {

    private lateinit var mPresenter: CartCheckoutPresenter
    private lateinit var mAdapter: CartCheckOutAdapter
    private lateinit var mOrderList: List<FoodItemVO>

    companion object {
        private const val RESTAURANT_IMAGE = "PARAM_RESTAURANT_IMAGE"
        private const val RESTAURANT_NAME = "PARAM_RESTAURANT_NAME"
        private const val RESTAURANT_DESCRIPTION = "PARAM_RESTAURANT_DESCRIPTION"
        private const val RESTAURANT_RATING = "PARAM_RESTAURANT_RATING"
        fun newIntent(context: Context,
                      restaurant_name: String?, restaurant_description: String?,
                      restaurant_image: String?, restaurant_rating: String?
        ): Intent {
            val intent = Intent(context, CartCheckOutActivity::class.java)
            intent.putExtra(RESTAURANT_IMAGE, restaurant_image)
            intent.putExtra(RESTAURANT_NAME, restaurant_name)
            intent.putExtra(RESTAURANT_DESCRIPTION, restaurant_description)
            intent.putExtra(RESTAURANT_RATING, restaurant_rating)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        setUpUIView()
        setUpPresenter()
        setUpRecyclerView()
        setUpActionListener()
    }

    private fun setUpRecyclerView() {
        rv_orderList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mAdapter = CartCheckOutAdapter(mPresenter)
        rv_orderList.adapter = mAdapter
    }

    private fun setUpUIView() {
        tv_restaurant_name.text = intent.getStringExtra(RESTAURANT_NAME).toString()
        tv_restaurant_description.text = intent.getStringExtra(RESTAURANT_DESCRIPTION).toString()
        tv_restaurant_rating.text = intent.getStringExtra(RESTAURANT_RATING).toString()
        intent.getStringExtra(RESTAURANT_IMAGE)?.let {
            iv_restaurant.load(it)
        }
    }

    private fun setUpActionListener() {
        btn_checkout.setOnClickListener {
            if (mOrderList.isNotEmpty()) {
                showBottomSheetDialog()
            } else {
                Toast.makeText(this, "Empty Cart Item", Toast.LENGTH_LONG).show()
            }
        }
        ll_backpress.setOnClickListener {
            onBackPressed()
        }
    }

    private fun showBottomSheetDialog() {
        val view = layoutInflater.inflate(R.layout.checkout_success_dialog, null)
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(view)

        view.btn_order_track.setOnClickListener {

            Toast.makeText(this, "Order Track Clicked", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
            mPresenter.onTapCheckoutItems(orderList = mOrderList)
            this.finish()

        }
        view.btn_order_something.setOnClickListener {
            Toast.makeText(this, "Order Cancel Clicked", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        dialog.show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<CartCheckoutPresenterImpl, CartCheckOutView>()
        mPresenter.onUiReady(this)

    }

    override fun showOrdersList(orderList: List<FoodItemVO>) {
        mOrderList = orderList
        mAdapter.setNewData(orderList as MutableList<FoodItemVO>)
    }

    override fun showCalculationTotalCharge(totalAmount: Long) {
        tv_total_Amount.text = "$totalAmount Ks"
    }

    override fun showError(error: String) {

    }
}