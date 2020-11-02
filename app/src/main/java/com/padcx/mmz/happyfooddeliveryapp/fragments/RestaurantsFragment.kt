package com.padcx.mmz.happyfooddeliveryapp.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.padcx.mmz.happyfooddeliveryapp.R
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
    }

    private fun setUpPresenter() {
        activity?.let {
            mPresenter = getPresenter<HomePresenterImpl, HomeView>()
            mPresenter.onUiReady(this)
        }
    }

    override fun changeHomeScreenViewType(viewType: Int) {
        if (viewType == 0) {
            Toast.makeText(context, "Layout Type...$viewType", Toast.LENGTH_SHORT).show()
            changeHomeScreenOne()
        } else {
            Toast.makeText(context, "Layout Type...$viewType", Toast.LENGTH_SHORT).show()
            changeHomeScreenTwo()
        }
    }

    private fun changeHomeScreenTwo() {
        location_layout.visibility = View.GONE
        rv_category.visibility = View.GONE
        ly_restaurant.visibility = View.VISIBLE
        ly_popular.visibility = View.VISIBLE
        rv_popular_choice.visibility = View.VISIBLE
    }

    private fun changeHomeScreenOne() {
        location_layout.visibility = View.VISIBLE
        rv_category.visibility = View.VISIBLE
        ly_restaurant.visibility = View.GONE
        ly_popular.visibility = View.GONE
        rv_popular_choice.visibility = View.GONE
    }

    override fun navigateToDetailScreen(documentId: String) {

    }

    override fun showErrorMessage(message: String) {

    }

    override fun showCategories(categoryList: List<CategoryVO>) {

    }

    override fun showRestaurants(restaurantList: List<RestaurantVO>) {

    }

    override fun showPopularChoicesFoodItems(popularChoiceList: List<FoodItemVO>) {

    }
}