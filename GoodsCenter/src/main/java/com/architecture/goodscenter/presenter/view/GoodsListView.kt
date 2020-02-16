package com.architecture.goodscenter.presenter.view

import com.architecture.baselibrary.presenter.view.BaseView
import com.architecture.goodscenter.data.protocol.Goods


/*
    商品列表 视图回调
 */
interface GoodsListView : BaseView {

    //获取商品列表
    fun onGetGoodsListResult(result: MutableList<Goods>?)
}
