package com.architecture.ui.activity.main

import com.architecture.R
import com.architecture.base.BaseActivity

/**
 * Created by Sven.Wong on 2020-02-10
 */

class MainActivity :
    BaseActivity<ActivityMainBinding, MainActivityViewModel>(MainActivityViewModel::class.java) {

    override fun getLayoutRes() = R.layout.activity_main
    override fun onInject() {
        app.component.inject(this)

    }

}
