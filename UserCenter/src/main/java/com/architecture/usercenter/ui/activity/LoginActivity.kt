package com.architecture.usercenter.ui.activity

import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.architecture.baselibrary.ext.enable
import com.architecture.baselibrary.ext.onClick
import com.architecture.baselibrary.ui.activity.BaseMvpActivity
import com.architecture.usercenter.data.protocol.UserInfo
import com.architecture.usercenter.injection.component.DaggerUserComponent
import com.architecture.usercenter.injection.module.UserModule
import com.architecture.usercenter.presenter.LoginPresenter
import com.architecture.usercenter.presenter.view.LoginView
import com.architecture.usercenter.utils.UserPrefsUtils
import com.kotlin.provider.PushProvider
import com.kotlin.provider.router.RouterPath
import com.kotlin.user.R
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import com.architecture.usercenter.ui.activity.RegisterActivity as RegisterActivity1

/*
    登录界面
 */
@Route(path = RouterPath.UserCenter.PATH_LOGIN)
class LoginActivity : BaseMvpActivity<LoginPresenter>(), LoginView, View.OnClickListener {

    @Autowired(name = RouterPath.MessageCenter.PATH_MESSAGE_PUSH)
    @JvmField
    var mPushProvider: PushProvider? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initView()
    }

    /*
        初始化视图
     */
    private fun initView() {

        mLoginBtn.enable(mMobileEt,{isBtnEnable()})
        mLoginBtn.enable(mPwdEt,{isBtnEnable()})

        mLoginBtn.onClick(this)
        mHeaderBar.getRightView().onClick(this)
        mForgetPwdTv.onClick(this)

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
            R.id.mRightTv -> {startActivity<RegisterActivity1>()}

            R.id.mLoginBtn -> {
                mPresenter.login(mMobileEt.text.toString(),mPwdEt.text.toString(),mPushProvider?.getPushId()?:"")
            }
            R.id.mForgetPwdTv ->{
                startActivity<ForgetPwdActivity>()
            }
        }
    }

    /*
        判断按钮是否可用
     */
    private fun isBtnEnable():Boolean{
        return mMobileEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()
    }

    /*
        登录回调
     */
    override fun onLoginResult(result: UserInfo) {
        toast("登录成功")
        UserPrefsUtils.putUserInfo(result)
        finish()
    }
}
