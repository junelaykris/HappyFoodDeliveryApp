package com.padcx.mmz.happyfooddeliveryapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcx.mmz.happyfooddeliveryapp.R
import com.padcx.mmz.happyfooddeliveryapp.adapters.PopularChoiceDetailAdapter
import com.padcx.mmz.happyfooddeliveryapp.adapters.RestaurantDetailAdapter
import com.padcx.mmz.happyfooddeliveryapp.data.vos.FoodItemVO
import com.padcx.mmz.happyfooddeliveryapp.data.vos.RestaurantVO
import com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.DetailPresenter
import com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.impls.DetailPresenterImpl
import com.padcx.mmz.happyfooddeliveryapp.mvp.views.DetailView
import com.padcx.mmz.happyfooddeliveryapp.utils.load
import com.padcx.mmz.shared.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_restaurant_detail.*
import kotlinx.android.synthetic.main.content_scrolling.*

/**
 * Created by Myint Myint Zaw on 11/4/2020.
 */
class RestaurantDetailActivity :BaseActivity(),DetailView{

    private lateinit var mPresenter: DetailPresenter

    private lateinit var mDetailAdapter: RestaurantDetailAdapter
    private lateinit var mPopularChoiceDetailAdapter: PopularChoiceDetailAdapter
    private lateinit var mRestaurantVO: RestaurantVO

    companion object {
        const val PARAM_ID= "Restaurant ID"
        fun newIntent(context: Context, documentId: String): Intent {
            val intent = Intent(context, RestaurantDetailActivity::class.java)
            intent.putExtra(PARAM_ID, documentId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)
        setUpPresenter()
        setUpRecyclerView()
        setUpActionListener()
    }

    private fun setUpActionListener() {

        toolbar.setOnClickListener {
            onBackPressed()
        }

        btn_cart.setOnClickListener {
            mRestaurantVO?.let {
                startActivity(CartCheckOutActivity.newIntent(this,it?.name,it?.description,it?.image_url,it?.rating))
            }

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    private fun setUpRecyclerView() {
        rv_detail_popular_choice.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_food_items.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        mDetailAdapter = RestaurantDetailAdapter (mPresenter)
        rv_food_items.adapter = mDetailAdapter

        mPopularChoiceDetailAdapter = PopularChoiceDetailAdapter ()
        rv_detail_popular_choice.adapter = mPopularChoiceDetailAdapter

    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<DetailPresenterImpl, DetailView>()
        mPresenter.onUiReady(this)
        mPresenter.onFetchRestaurantDetailData(this,intent.getStringExtra(PARAM_ID).toString())
    }

    override fun showRestaurantData(restaurantVO: RestaurantVO) {
        mRestaurantVO =restaurantVO
        detail_description.text =restaurantVO.description
        tv_detail_rating.text =restaurantVO.rating
        tv_detail_title.text =restaurantVO.name
        restaurantVO.image_url?.let{
            detail_image.load(it)
        }
    }

    override fun showPopularChoicesFoodItem(popularFoodList: List<FoodItemVO>) {
        mPopularChoiceDetailAdapter.setNewData(popularFoodList as MutableList<FoodItemVO>)
    }

    override fun showFoodItemList(foodList: List<FoodItemVO>) {
        mDetailAdapter.setNewData(foodList as MutableList<FoodItemVO>)
    }

    override fun showViewCartCount(cartCount: Long) {
        if(cartCount>0) {
            btn_cart.visibility= View.VISIBLE
            btn_cart.text="View Cart ${cartCount} items"
        }else{
            btn_cart.visibility= View.GONE
        }
    }

    override fun showError(error: String) {
        Toast.makeText(this, "Error...$error", Toast.LENGTH_SHORT).show()
    }
}