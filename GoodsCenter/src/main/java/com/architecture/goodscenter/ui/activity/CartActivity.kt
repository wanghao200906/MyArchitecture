package com.architecture.goodscenter.ui.activity

import android.os.Bundle
import com.architecture.baselibrary.ui.activity.BaseActivity
import com.architecture.goodscenter.R
import com.architecture.goodscenter.ui.fragment.CartFragment

/*
    购物车Activity
    只是Fragment一个壳
 */
class CartActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_cart)
        (fragment as CartFragment).setBackVisible(true)

    }
}
