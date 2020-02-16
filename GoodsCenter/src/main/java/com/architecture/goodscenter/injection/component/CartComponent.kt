package com.architecture.goodscenter.injection.component

import com.architecture.baselibrary.injection.PerComponentScope
import com.architecture.baselibrary.injection.component.ActivityComponent
import com.architecture.goodscenter.injection.module.CartModule
import com.architecture.goodscenter.ui.fragment.CartFragment
import dagger.Component

/*
    购物车Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(CartModule::class))
interface CartComponent {
    fun inject(fragment: CartFragment)
}
