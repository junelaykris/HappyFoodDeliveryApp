package com.padcx.mmz.happyfooddeliveryapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.padcx.mmz.happyfooddeliveryapp.R
import com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.RegisterPresenter
import com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.impls.RegisterPresenterImpl
import com.padcx.mmz.happyfooddeliveryapp.mvp.views.RegisterView
import com.padcx.mmz.shared.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_register.*

/**
 * Created by Myint Myint Zaw on 11/2/2020.
 */
class RegisterActivity: BaseActivity() , RegisterView {

    private lateinit var mPresenter: RegisterPresenter

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setUpPresenter()
        setUpActionListeners()
    }

    private fun setUpActionListeners() {
        btnRegister.setOnClickListener {
            mPresenter.onTapRegister(
                etUserName.text.toString(),
                etEmail.text.toString(),
                etPassword.text.toString(),
                etPhone.text.toString())
        }
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<RegisterPresenterImpl, RegisterView>()
        mPresenter.onUiReady(this)
    }

    override fun navigateToToLoginScreen() {
        startActivity(LoginActivity.newIntent(this))
        this.finish()
    }

    override fun showError(error: String) {
      Toast.makeText(this, "Error...$error",Toast.LENGTH_SHORT).show()
    }
}