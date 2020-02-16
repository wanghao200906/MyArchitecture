package com.architecture.ordercenter.presenter

import com.architecture.baselibrary.ext.excute
import com.architecture.baselibrary.presenter.BasePresenter
import com.architecture.baselibrary.rx.BaseSubscriber
import com.architecture.ordercenter.data.protocol.Order
import com.architecture.ordercenter.presenter.view.OrderDetailView
import com.architecture.ordercenter.service.OrderService
import javax.inject.Inject

/*
    订单详情页Presenter
 */
class OrderDetailPresenter @Inject constructor() : BasePresenter<OrderDetailView>() {

    @Inject
    lateinit var orderService: OrderService

    /*
        根据ID查询订单
     */
    fun getOrderById(orderId: Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        orderService.getOrderById(orderId).excute(object : BaseSubscriber<Order>(mView) {
            override fun onNext(t: Order) {
                    mView.onGetOrderByIdResult(t)
            }
        }
//            , lifecycleProvider
        )

    }

}
