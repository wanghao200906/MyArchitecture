package com.architecture.di.component

import android.content.Context
import android.content.SharedPreferences
import com.architecture.App
import com.architecture.di.module.ApplicationModule
import com.architecture.di.module.NetModule
import com.architecture.ui.activity.main.MainActivity
import com.architecture.ui.activity.main.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Sven.Wong on 2020-02-10
 */

@Singleton
@Component(modules = [ApplicationModule::class, NetModule::class
//    , DatabaseModule::class
])
interface ApplicationComponent {

    object Initializer {
        fun init(app: App): ApplicationComponent {
            return DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(app))
                .build()
        }
    }

    fun app(): App

    fun context(): Context

    fun preferences(): SharedPreferences

    fun inject(mainActivityViewModel: MainActivityViewModel)

    fun inject(activity: MainActivity)
}
