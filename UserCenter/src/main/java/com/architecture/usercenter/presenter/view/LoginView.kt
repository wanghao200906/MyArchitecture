package com.architecture.usercenter.presenter.view

import com.architecture.baselibrary.presenter.view.BaseView
import com.architecture.usercenter.data.protocol.UserInfo

/*
    用户登录 视图回调
 */
interface LoginView : BaseView {

    fun onLoginResult(result: UserInfo)
}
