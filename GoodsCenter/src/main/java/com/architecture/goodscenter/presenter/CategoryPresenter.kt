package com.architecture.goodscenter.presenter

import com.architecture.baselibrary.ext.excute
import com.architecture.baselibrary.presenter.BasePresenter
import com.architecture.baselibrary.rx.BaseSubscriber
import com.architecture.goodscenter.data.protocol.Category
import com.architecture.goodscenter.presenter.view.CategoryView
import com.architecture.goodscenter.service.CategoryService
import javax.inject.Inject

/*
    商品分类 Presenter
 */
class CategoryPresenter @Inject constructor() : BasePresenter<CategoryView>() {

    @Inject
    lateinit var categoryService: CategoryService


    /*
        获取商品分类列表
     */
    fun getCategory(parentId:Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        categoryService.getCategory(parentId).excute(object : BaseSubscriber<MutableList<Category>?>(mView) {
            override fun onNext(t: MutableList<Category>?) {
                    mView.onGetCategoryResult(t)
            }
        }
//            , lifecycleProvider
        )

    }

}
