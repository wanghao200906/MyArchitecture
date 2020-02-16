package com.architecture.usercenter.presenter

import com.architecture.baselibrary.ext.excute
import com.architecture.baselibrary.presenter.BasePresenter
import com.architecture.baselibrary.rx.BaseSubscriber
import com.architecture.usercenter.presenter.view.RegisterView
import com.architecture.usercenter.service.UserService
import javax.inject.Inject

/*
    用户注册Presenter
 */
class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {

    @Inject
    lateinit var userService: UserService


    fun register(mobile: String, pwd: String, verifyCode: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()

        userService.register(mobile, pwd, verifyCode).excute(object : BaseSubscriber<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                if (t)
                    mView.onRegisterResult("注册成功")
            }
        }//            , lifecycleProvider
        )

    }

}
