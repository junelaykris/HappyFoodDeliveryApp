package com.padcx.mmz.happyfooddeliveryapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.padcx.mmz.happyfooddeliveryapp.R
import com.padcx.mmz.happyfooddeliveryapp.fragments.AccountFragment
import com.padcx.mmz.happyfooddeliveryapp.fragments.OffersFragment
import com.padcx.mmz.happyfooddeliveryapp.fragments.RestaurantsFragment
import com.padcx.mmz.shared.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swapFragment(RestaurantsFragment.newInstance(this))

        bottomNavigation.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.action_restaurants -> {
                        swapFragment(RestaurantsFragment.newInstance(this@MainActivity))
                        return true
                    }
                    R.id.action_offers -> {
                        swapFragment(OffersFragment.newInstance(this@MainActivity))
                        return true
                    }
                    R.id.action_profile -> {
                        swapFragment(AccountFragment.newInstance(this@MainActivity))
                        return true
                    }
                }
                return false
            }

        })

    }

    private fun swapFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.flBottomNavigationContainer, fragment)
            .commit()

    }
}