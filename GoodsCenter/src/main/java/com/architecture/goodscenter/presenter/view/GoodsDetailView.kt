package com.architecture.goodscenter.presenter.view

import com.architecture.baselibrary.presenter.view.BaseView
import com.architecture.goodscenter.data.protocol.Goods

/*
    商品详情 视图回调
 */
interface GoodsDetailView : BaseView {

    //获取商品详情
    fun onGetGoodsDetailResult(result: Goods)
    //加入购物车
    fun onAddCartResult(result: Int)
}
