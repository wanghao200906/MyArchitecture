package com.architecture.messagecenter.injection.module

import com.architecture.messagecenter.service.MessageService
import com.architecture.messagecenter.service.impl.MessageServiceImpl
import dagger.Module
import dagger.Provides

/*
    消息模块业务注入
 */
@Module
class MessageModule {

    @Provides
    fun provideMessageService(messageService: MessageServiceImpl): MessageService {
        return  messageService
    }

}
