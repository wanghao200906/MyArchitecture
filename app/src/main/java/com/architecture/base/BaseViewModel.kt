package com.architecture.base

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.architecture.App

/**
 * Created by Sven.Wong on 2020-02-10
 */

open class BaseViewModel(app: Application) : AndroidViewModel(app) {
      protected var application: App = (app as App)

}