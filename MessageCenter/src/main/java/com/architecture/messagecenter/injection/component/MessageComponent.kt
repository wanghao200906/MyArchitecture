package com.architecture.messagecenter.injection.component


import com.architecture.baselibrary.injection.PerComponentScope
import com.architecture.baselibrary.injection.component.ActivityComponent
import com.architecture.messagecenter.injection.module.MessageModule
import com.architecture.messagecenter.ui.fragment.MessageFragment
import dagger.Component

/*
    消息模块注入组件
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),
        modules = arrayOf(MessageModule::class))
interface MessageComponent{
    fun inject(fragment: MessageFragment)
}
