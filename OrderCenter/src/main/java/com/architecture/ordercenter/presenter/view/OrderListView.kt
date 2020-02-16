package com.architecture.ordercenter.presenter.view

import com.architecture.baselibrary.presenter.view.BaseView
import com.architecture.ordercenter.data.protocol.Order


/*
    订单列表 视图回调
 */
interface OrderListView : BaseView {

    //获取订单列表回调
    fun onGetOrderListResult(result:MutableList<Order>?)
    //确认订单回调
    fun onConfirmOrderResult(result:Boolean)
    //取消订单回调
    fun onCancelOrderResult(result:Boolean)

}
