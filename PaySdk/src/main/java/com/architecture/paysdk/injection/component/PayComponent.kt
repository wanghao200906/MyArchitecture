package com.architecture.paysdk.injection.component

import com.architecture.baselibrary.injection.PerComponentScope
import com.architecture.baselibrary.injection.component.ActivityComponent
import com.architecture.paysdk.injection.module.PayModule
import com.architecture.paysdk.ui.activity.CashRegisterActivity
import dagger.Component

/*
    支付Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(PayModule::class))
interface PayComponent {
    fun inject(activity: CashRegisterActivity)
}
