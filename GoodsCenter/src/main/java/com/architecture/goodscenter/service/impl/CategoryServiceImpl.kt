package com.architecture.goodscenter.service.impl

import com.architecture.baselibrary.ext.convert
import com.architecture.goodscenter.data.protocol.Category
import com.architecture.goodscenter.data.repository.CategoryRepository
import com.architecture.goodscenter.service.CategoryService
import io.reactivex.Observable
import javax.inject.Inject


/*
    商品分类 业务层 实现类
 */
class CategoryServiceImpl @Inject constructor(): CategoryService {
    @Inject
    lateinit var repository: CategoryRepository

    /*
        获取商品分类列表
     */
    override fun getCategory(parentId: Int): Observable<MutableList<Category>?> {
        return repository.getCategory(parentId).convert()
    }


}
