package com.architecture.usercenter.data.respository

import com.architecture.usercenter.data.api.UploadApi
import com.architecture.baselibrary.data.net.RetrofitFactory
import com.architecture.baselibrary.data.protocol.BaseResp
import io.reactivex.Observable
import javax.inject.Inject

/*
    上传相关 数据层
 */
class UploadRepository @Inject constructor(){
    /*
        获取七牛云上传凭证
     */
    fun getUploadToken(): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UploadApi::class.java).getUploadToken()
    }


}
