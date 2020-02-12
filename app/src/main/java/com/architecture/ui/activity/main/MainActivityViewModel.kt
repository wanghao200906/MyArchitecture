package com.architecture.ui.activity.main

import android.app.Application
import com.architecture.R
import com.architecture.base.BaseViewModel
import com.architecture.db.AppDatabase
import javax.inject.Inject

/**
 * Created by Sven.Wong on 2020-02-10
 */


class MainActivityViewModel(app: Application) : BaseViewModel(app) {

    @Inject
    lateinit var db: AppDatabase

    init {
        application.component.inject(this)
    }

    fun getAppName() = getApplication<Application>().resources.getString(R.string.app_name)

}