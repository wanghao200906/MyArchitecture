package com.architecture.usercenter.injection.component

import com.architecture.baselibrary.injection.PerComponentScope
import com.architecture.baselibrary.injection.component.ActivityComponent
import com.architecture.usercenter.injection.module.UploadModule
import com.architecture.usercenter.injection.module.UserModule
import com.architecture.usercenter.ui.activity.*
import dagger.Component

/*
    用户模块Component
 */
@PerComponentScope
@Component(
    dependencies = arrayOf(ActivityComponent::class)
    , modules = arrayOf(UserModule::class, UploadModule::class)
)
interface UserComponent {
    fun inject(activity: RegisterActivity)
    fun inject(activity: LoginActivity)
    fun inject(activity: ForgetPwdActivity)
    fun inject(activity: ResetPwdActivity)
    fun inject(activity: UserInfoActivity)
}
