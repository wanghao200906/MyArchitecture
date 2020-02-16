package com.architecture.usercenter.presenter.view

import com.architecture.baselibrary.presenter.view.BaseView

/*
    忘记密码 视图回调
 */
interface ForgetPwdView : BaseView {

    /*
        忘记密码回调
     */
    fun onForgetPwdResult(result:String)
}
