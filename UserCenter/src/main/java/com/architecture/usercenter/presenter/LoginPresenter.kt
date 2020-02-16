package com.architecture.usercenter.presenter

import com.architecture.baselibrary.ext.excute
import com.architecture.baselibrary.presenter.BasePresenter
import com.architecture.baselibrary.rx.BaseSubscriber
import com.architecture.usercenter.data.protocol.UserInfo
import com.architecture.usercenter.presenter.view.LoginView
import com.architecture.usercenter.service.UserService
import javax.inject.Inject


/*
    登录界面 Presenter
 */
class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {

    @Inject
    lateinit var userService: UserService

    /*
        登录
     */
    fun login(mobile: String, pwd: String, pushId: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        userService.login(mobile, pwd, pushId).excute(object : BaseSubscriber<UserInfo>(mView) {
            override fun onNext(t: UserInfo) {
                    mView.onLoginResult(t)
            }
        }//            , lifecycleProvider
        )

    }

}
