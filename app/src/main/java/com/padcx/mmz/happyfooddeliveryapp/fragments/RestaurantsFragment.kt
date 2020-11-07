package com.padcx.mmz.happyfooddeliveryapp.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcx.mmz.happyfooddeliveryapp.R
import com.padcx.mmz.happyfooddeliveryapp.activities.RestaurantDetailActivity
import com.padcx.mmz.happyfooddeliveryapp.adapters.CategoryAdapter
import com.padcx.mmz.happyfooddeliveryapp.adapters.PopularChoiceAdapter
import com.padcx.mmz.happyfooddeliveryapp.adapters.RestaurantAdapter
import com.padcx.mmz.happyfooddeliveryapp.data.vos.CategoryVO
import com.padcx.mmz.happyfooddeliveryapp.data.vos.FoodItemVO
import com.padcx.mmz.happyfooddeliveryapp.data.vos.RestaurantVO
import com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.HomePresenter
import com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.impls.HomePresenterImpl
import com.padcx.mmz.happyfooddeliveryapp.mvp.views.HomeView
import com.padcx.mmz.shared.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_restaurants.*

/**
 * Created by Myint Myint Zaw on 11/2/2020.
 */
class RestaurantsFragment : BaseFragment(), HomeView {

    private lateinit var mPresenter: HomePresenter
    private lateinit var mRestaurantAdapter: RestaurantAdapter

    private lateinit var mCategoryAdapter: CategoryAdapter
    private lateinit var mPopularChoiceAdapter: PopularChoiceAdapter

    companion object {
        lateinit var mContext: Context
        fun newInstance(context: Context): RestaurantsFragment {
            mContext = context
            return RestaurantsFragment()
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_restaurants, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {

        rv_category.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rv_popular_choice.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rv_restaurants.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        mCategoryAdapter = CategoryAdapter(mPresenter)
        rv_category.adapter = mCategoryAdapter

        mPopularChoiceAdapter = PopularChoiceAdapter(mPresenter)
        rv_popular_choice.adapter = mPopularChoiceAdapter

    }

    private fun setUpPresenter() {
        activity?.let {
            mPresenter = getPresenter<HomePresenterImpl, HomeView>()
            mPresenter.onUiReady(this)
        }
    }

    override fun changeHomeScreenViewType(viewType: Int) {
        if (viewType == 0) {
            changeHomeScreenOne(viewType)
        } else {
            changeHomeScreenTwo(viewType)
        }
    }

    private fun changeHomeScreenTwo(viewType: Int) {
        location_layout.visibility = View.GONE
        rv_category.visibility = View.GONE
        ly_restaurant.visibility = View.VISIBLE
        ly_popular.visibility = View.VISIBLE
        rv_popular_choice.visibility = View.VISIBLE
        mRestaurantAdapter = RestaurantAdapter(mPresenter, viewType)
        rv_restaurants.adapter = mRestaurantAdapter
    }

    private fun changeHomeScreenOne(viewType: Int) {
        location_layout.visibility = View.VISIBLE
        rv_category.visibility = View.VISIBLE
        ly_restaurant.visibility = View.GONE
        ly_popular.visibility = View.GONE
        rv_popular_choice.visibility = View.GONE
        mRestaurantAdapter = RestaurantAdapter(mPresenter, viewType)
        rv_restaurants.adapter = mRestaurantAdapter
    }

    override fun navigateToDetailScreen(documentId: String) {
        startActivity(activity?.applicationContext?.let{
            RestaurantDetailActivity.newIntent(it, documentId)})
    }

    override fun showErrorMessage(message: String) {
    }

    override fun showCategories(categoryList: List<CategoryVO>) {
        mCategoryAdapter.setNewData(categoryList as MutableList<CategoryVO>)
    }

    override fun showRestaurants(restaurantList: List<RestaurantVO>) {
        mRestaurantAdapter.setNewData(restaurantList as MutableList<RestaurantVO>)
    }

    override fun showPopularChoicesFoodItems(popularChoiceList: List<FoodItemVO>) {
        mPopularChoiceAdapter.setNewData(popularChoiceList as MutableList<FoodItemVO>)
    }
}