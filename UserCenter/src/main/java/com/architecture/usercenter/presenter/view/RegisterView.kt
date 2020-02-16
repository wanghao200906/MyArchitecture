package com.architecture.usercenter.presenter.view

import com.architecture.baselibrary.presenter.view.BaseView

/*
    用户注册 视图回调
 */
interface RegisterView: BaseView {

    fun onRegisterResult(result:String)
}
