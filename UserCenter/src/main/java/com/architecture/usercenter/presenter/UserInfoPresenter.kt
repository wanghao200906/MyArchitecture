package com.architecture.usercenter.presenter

import com.architecture.baselibrary.ext.excute
import com.architecture.baselibrary.presenter.BasePresenter
import com.architecture.baselibrary.rx.BaseSubscriber
import com.architecture.usercenter.data.protocol.UserInfo
import com.architecture.usercenter.presenter.view.UserInfoView
import com.architecture.usercenter.service.UploadService
import com.architecture.usercenter.service.UserService
import javax.inject.Inject

/*
    编辑用户资料Presenter
 */
class UserInfoPresenter @Inject constructor() : BasePresenter<UserInfoView>() {

    @Inject
    lateinit var userService: UserService

    @Inject
    lateinit var uploadService: UploadService

    /*
        获取七牛云上传凭证
     */
    fun getUploadToken(){
        if (!checkNetWork())
            return

        mView.showLoading()
        uploadService.getUploadToken().excute(object : BaseSubscriber<String>(mView){
            override fun onNext(t: String) {
                mView.onGetUploadTokenResult(t)
            }
        }//            , lifecycleProvider
        )
    }

    /*
        编辑用户资料
     */
    fun editUser(userIcon:String,userName:String,userGender:String,userSign:String){
        if (!checkNetWork())
            return

        mView.showLoading()
        userService.editUser(userIcon,userName,userGender,userSign).excute(object :
            BaseSubscriber<UserInfo>(mView){
            override fun onNext(t: UserInfo) {
                mView.onEditUserResult(t)
            }
        }
//            ,lifecycleProvider
        )
    }

}
