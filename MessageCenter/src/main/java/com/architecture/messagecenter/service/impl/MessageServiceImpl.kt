package com.architecture.messagecenter.service.impl


import com.architecture.baselibrary.ext.convert
import com.architecture.messagecenter.data.protocol.Message
import com.architecture.messagecenter.data.repository.MessageRepository
import com.architecture.messagecenter.service.MessageService
import io.reactivex.Observable
import javax.inject.Inject

/*
   消息业务层
 */
class MessageServiceImpl @Inject constructor(): MessageService {

    @Inject
    lateinit var repository: MessageRepository

    /*
        获取消息列表
     */
    override fun getMessageList(): Observable<MutableList<Message>?> {
        return repository.getMessageList().convert()
    }

}
