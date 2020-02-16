package com.architecture.goodscenter.data.repository

import com.architecture.baselibrary.data.net.RetrofitFactory
import com.architecture.baselibrary.data.protocol.BaseResp
import com.architecture.goodscenter.data.api.CategoryApi
import com.architecture.goodscenter.data.protocol.Category
import com.architecture.goodscenter.data.protocol.GetCategoryReq
import io.reactivex.Observable
import javax.inject.Inject

/*
    商品分类 数据层
 */
class CategoryRepository @Inject constructor(){
    /*
        获取商品分类
     */
    fun getCategory(parentId: Int): Observable<BaseResp<MutableList<Category>?>> {
        return RetrofitFactory.instance.create(CategoryApi::class.java).getCategory(GetCategoryReq(parentId))
    }

}
