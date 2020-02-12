package com.architecture

import android.app.Application
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ProcessLifecycleOwner
import android.content.Context
import com.architecture.di.component.ApplicationComponent

class App : Application(), LifecycleObserver {


    val component by lazy {
        ApplicationComponent.Initializer.init(this)
    }

    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onInit() {
//        val processName: String? = SystemUtils.getProcessName(this, Process.myPid())
//        if (processName != null) {
//            val defaultProcess = BuildConfig.APPLICATION_ID == processName
//            if (defaultProcess) {
//                context=this
//                init1()
//            }
//        }
    }

    private fun init1() {


    }

    companion object{
        lateinit var context: Context
    }

}

