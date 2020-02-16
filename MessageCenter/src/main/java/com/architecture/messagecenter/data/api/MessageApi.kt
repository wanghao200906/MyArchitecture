package com.architecture.messagecenter.data.api

import com.architecture.baselibrary.data.protocol.BaseResp
import com.architecture.messagecenter.data.protocol.Message
import io.reactivex.Observable
import retrofit2.http.POST

/*
    消息 接口
 */
interface MessageApi {

    /*
        获取消息列表
     */
    @POST("msg/getList")
    fun getMessageList(): Observable<BaseResp<MutableList<Message>?>>

}
