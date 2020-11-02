package com.padcx.mmz.happyfooddeliveryapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.padcx.mmz.happyfooddeliveryapp.R
import com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.LoginPresenter
import com.padcx.mmz.happyfooddeliveryapp.mvp.presenters.impls.LoginPresenterImpl
import com.padcx.mmz.happyfooddeliveryapp.mvp.views.LoginView
import com.padcx.mmz.shared.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by Myint Myint Zaw on 11/1/2020.
 */
class LoginActivity : BaseActivity(), LoginView {

    private lateinit var mPresenter: LoginPresenter

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setUpPresenter()
        setUpActionListeners()
    }

    private fun setUpActionListeners() {
        btnLogin.setOnClickListener {
            mPresenter.onTapLogin(edt_email.text.toString(), edt_password.text.toString())
        }

        btnRegister.setOnClickListener {
            mPresenter.onTapRegister()
        }
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<LoginPresenterImpl, LoginView>()
        mPresenter.onUiReady(this)
    }

    override fun navigateToHomeScreen() {
        startActivity(MainActivity.newIntent(this))
        this.finish()
    }

    override fun navigateToRegisterScreen() {
        startActivity(RegisterActivity.newIntent(this))
        this.finish()
    }

    override fun showError(error: String) {
        Toast.makeText(this, "Error...$error", Toast.LENGTH_SHORT).show()
    }
}