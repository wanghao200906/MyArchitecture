package com.architecture.ordercenter.presenter.view

import com.architecture.baselibrary.presenter.view.BaseView
import com.architecture.ordercenter.data.protocol.Order


/*
    订单详情页 视图回调
 */
interface OrderDetailView : BaseView {

    fun onGetOrderByIdResult(result: Order)
}
