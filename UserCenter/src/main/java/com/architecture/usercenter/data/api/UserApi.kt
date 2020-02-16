package com.architecture.usercenter.data.api

import com.architecture.usercenter.data.protocol.*
import com.architecture.baselibrary.data.protocol.BaseResp
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/*
    用户相关 接口
 */
interface UserApi{

    /*
        用户注册
     */
    @POST("userCenter/register")
    fun register(@Body req: RegisterReq): Observable<BaseResp<String>>

    /*
        用户登录
     */
    @POST("userCenter/login")
    fun login(@Body req: LoginReq):Observable<BaseResp<UserInfo>>

    /*
        忘记密码
     */
    @POST("userCenter/forgetPwd")
    fun forgetPwd(@Body req: ForgetPwdReq):Observable<BaseResp<String>>

    /*
        重置密码
     */
    @POST("userCenter/resetPwd")
    fun resetPwd(@Body req: ResetPwdReq):Observable<BaseResp<String>>

    /*
        编辑用户资料
     */
    @POST("userCenter/editUser")
    fun editUser(@Body req: EditUserReq):Observable<BaseResp<UserInfo>>
}
