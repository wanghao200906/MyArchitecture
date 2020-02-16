package com.architecture.goodscenter.injection.component

import com.architecture.baselibrary.injection.PerComponentScope
import com.architecture.baselibrary.injection.component.ActivityComponent
import com.architecture.goodscenter.injection.module.CategoryModule
import com.architecture.goodscenter.ui.fragment.CategoryFragment
import dagger.Component

/*
    商品分类Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(CategoryModule::class))
interface CategoryComponent {
    fun inject(fragment: CategoryFragment)
}
