package com.padcx.mmz.happyfooddeliveryapp.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.padcx.mmz.happyfooddeliveryapp.R
import com.padcx.mmz.shared.fragment.BaseFragment

/**
 * Created by Myint Myint Zaw on 11/2/2020.
 */
class AccountFragment: BaseFragment(){


    companion object {
        lateinit var mContext: Context
        fun newInstance(context: Context): AccountFragment {
            mContext = context
            return AccountFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_account, container, false)
        return view
    }
}