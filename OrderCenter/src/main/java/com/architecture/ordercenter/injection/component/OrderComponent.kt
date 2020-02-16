package com.architecture.ordercenter.injection.component

import com.architecture.baselibrary.injection.PerComponentScope
import com.architecture.baselibrary.injection.component.ActivityComponent
import com.architecture.ordercenter.injection.module.OrderModule
import com.architecture.ordercenter.ui.activity.OrderConfirmActivity
import com.architecture.ordercenter.ui.activity.OrderDetailActivity
import com.architecture.ordercenter.ui.fragment.OrderFragment
import dagger.Component

/*
    订单Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(OrderModule::class))
interface OrderComponent {
    fun inject(activity: OrderConfirmActivity)
    fun inject(fragment: OrderFragment)

    fun inject(activity: OrderDetailActivity)
}
