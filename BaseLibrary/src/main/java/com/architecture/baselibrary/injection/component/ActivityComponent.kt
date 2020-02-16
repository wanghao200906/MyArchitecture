package com.architecture.baselibrary.injection.component

import android.app.Activity
import android.content.Context
import com.architecture.baselibrary.injection.ActivityScope
import com.architecture.baselibrary.injection.module.ActivityModule
import dagger.Component

/*
    Activity级别Component
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class)
    ,modules = arrayOf(
        ActivityModule::class
//        ,LifecycleProviderModule::class
    ))
interface ActivityComponent {

    fun activity():Activity
    fun context(): Context
//    fun lifecycleProvider(): LifecycleProvider<*>
}
