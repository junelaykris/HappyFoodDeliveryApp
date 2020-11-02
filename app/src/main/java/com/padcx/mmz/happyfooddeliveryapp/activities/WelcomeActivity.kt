package com.padcx.mmz.happyfooddeliveryapp.activities

import android.os.Bundle
import android.widget.Toast
import com.padcx.mmz.happyfooddeliveryapp.R
import com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.WelcomePresenter
import com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.impls.WelcomePresenterImpl
import com.padcx.mmz.happyfooddeliveryapp.mvp.views.WelcomeView
import com.padcx.mmz.shared.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_welcome_screeen.*

/**
 * Created by Myint Myint Zaw on 11/1/2020.
 */
class WelcomeActivity :BaseActivity(),WelcomeView{

    private lateinit var mPresenter: WelcomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_welcome_screeen)
        setUpPresenter()
        setUpActionListeners()
    }

    private fun setUpActionListeners() {
        btn_started.setOnClickListener{
            mPresenter.onTapStarted()
            this.finish()
        }
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<WelcomePresenterImpl, WelcomeView>()
        mPresenter.onUiReady(this)
    }

    override fun navigateToLoginScreen() {
        startActivity(LoginActivity.newIntent(this))
    }

    override fun showError(error: String) {
        Toast.makeText(this, "Error...$error", Toast.LENGTH_SHORT).show()
    }

}