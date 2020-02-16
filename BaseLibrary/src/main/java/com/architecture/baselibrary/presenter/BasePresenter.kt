package com.architecture.baselibrary.presenter

import android.content.Context
import com.architecture.baselibrary.presenter.view.BaseView
import com.architecture.baselibrary.utils.NetWorkUtils
import javax.inject.Inject

/**
 * Created by Sven.Wong on 2020-02-13
 */

abstract class BasePresenter<T:BaseView>{

    lateinit var mView:T

//
//    //Dagger注入，Rx生命周期管理
//    @Inject
//    lateinit var lifecycleProvider: LifecycleProvider<*>


    @Inject
    lateinit var context: Context

    /*
        检查网络是否可用
     */
    fun checkNetWork():Boolean{
        if(NetWorkUtils.isNetWorkAvailable(context)){
            return true
        }
        mView.onError("网络不可用")
        return false
    }
}