package com.architecture.ui.activity.main

import android.app.Application
import com.architecture.R
import com.architecture.base.BaseViewModel

/**
 * Created by Sven.Wong on 2020-02-10
 */


class MainActivityViewModel(app: Application) : BaseViewModel(app) {

    init {
        application.component.inject(this)
    }

    fun getAppName() = getApplication<Application>().resources.getString(R.string.app_name)

}