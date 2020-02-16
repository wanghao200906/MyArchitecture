package com.architecture.messagecenter.data.repository


import com.architecture.baselibrary.data.net.RetrofitFactory
import com.architecture.baselibrary.data.protocol.BaseResp
import com.architecture.messagecenter.data.api.MessageApi
import com.architecture.messagecenter.data.protocol.Message
import io.reactivex.Observable
import javax.inject.Inject


/*
   消息数据层
 */
class MessageRepository @Inject constructor() {

    /*
        获取消息列表
     */
    fun getMessageList(): Observable<BaseResp<MutableList<Message>?>> {
        return RetrofitFactory.instance.create(MessageApi::class.java).getMessageList()
    }



}
