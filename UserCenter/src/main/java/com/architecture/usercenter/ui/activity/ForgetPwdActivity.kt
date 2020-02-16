package com.architecture.usercenter.ui.activity

import android.os.Bundle
import android.view.View
import com.architecture.baselibrary.ext.enable
import com.architecture.baselibrary.ext.onClick
import com.architecture.baselibrary.ui.activity.BaseMvpActivity
import com.architecture.usercenter.injection.component.DaggerUserComponent
import com.architecture.usercenter.injection.module.UserModule
import com.architecture.usercenter.presenter.ForgetPwdPresenter
import com.architecture.usercenter.presenter.view.ForgetPwdView
import com.kotlin.user.R
import kotlinx.android.synthetic.main.activity_forget_pwd.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/*
    忘记密码界面
 */
class ForgetPwdActivity : BaseMvpActivity<ForgetPwdPresenter>(), ForgetPwdView, View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_pwd)

        initView()

    }

    /*
        初始化视图
     */
    private fun initView() {

        mNextBtn.enable(mMobileEt,{isBtnEnable()})
        mNextBtn.enable(mVerifyCodeEt,{isBtnEnable()})

//        mVerifyCodeBtn.onClick(this)
        mNextBtn.onClick(this)
    }

    /*
        Dagger注册
     */
    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    /*
        点击事件
     */
    override fun onClick(view: View) {
        when(view.id){
            R.id.mVerifyCodeBtn -> {
//                mVerifyCodeBtn.requestSendVerifyNumber()
                toast("发送验证成功")
            }

            R.id.mNextBtn -> {
            mPresenter.forgetPwd(mMobileEt.text.toString(),mVerifyCodeEt.text.toString())
            }
        }
    }

    /*
        判断按钮是否可用
     */
    private fun isBtnEnable():Boolean{
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeEt.text.isNullOrEmpty().not()
    }

    /*
        忘记密码回调
     */
    override fun onForgetPwdResult(result: String) {
        toast(result)
        startActivity<ResetPwdActivity>("mobile"  to mMobileEt.text.toString())
    }
}
