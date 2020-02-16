package com.architecture.goodscenter.injection.component

import com.architecture.baselibrary.injection.PerComponentScope
import com.architecture.baselibrary.injection.component.ActivityComponent
import com.architecture.goodscenter.injection.module.CartModule
import com.architecture.goodscenter.injection.module.GoodsModule
import com.architecture.goodscenter.ui.activity.GoodsActivity
import com.architecture.goodscenter.ui.fragment.GoodsDetailTabOneFragment
import dagger.Component

/*
    商品Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(
    GoodsModule::class,
    CartModule::class))
interface GoodsComponent {
    fun inject(activity: GoodsActivity)
    fun inject(fragment: GoodsDetailTabOneFragment)
}
