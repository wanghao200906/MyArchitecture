package com.architecture.ordercenter.injection.component

import com.architecture.baselibrary.injection.PerComponentScope
import com.architecture.baselibrary.injection.component.ActivityComponent
import com.architecture.ordercenter.injection.module.ShipAddressModule
import com.architecture.ordercenter.ui.activity.ShipAddressActivity
import com.architecture.ordercenter.ui.activity.ShipAddressEditActivity
import dagger.Component

/*
    收货人信息Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(ShipAddressModule::class))
interface ShipAddressComponent {
    fun inject(activity: ShipAddressEditActivity)
    fun inject(activity: ShipAddressActivity)
}
