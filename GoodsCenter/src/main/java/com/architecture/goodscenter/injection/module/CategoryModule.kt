package com.architecture.goodscenter.injection.module

import com.architecture.goodscenter.service.CategoryService
import com.architecture.goodscenter.service.impl.CategoryServiceImpl
import dagger.Module
import dagger.Provides

/*
    商品分类Module
 */
@Module
class CategoryModule {

    @Provides
    fun provideCategoryService(categoryService: CategoryServiceImpl): CategoryService {
        return categoryService
    }

}
