package com.architecture.ordercenter.presenter

import com.architecture.baselibrary.ext.excute
import com.architecture.baselibrary.presenter.BasePresenter
import com.architecture.baselibrary.rx.BaseSubscriber
import com.architecture.ordercenter.data.protocol.Order
import com.architecture.ordercenter.presenter.view.OrderConfirmView
import com.architecture.ordercenter.service.OrderService
import javax.inject.Inject

/*
    订单确认页 Presenter
 */
class OrderConfirmPresenter @Inject constructor() : BasePresenter<OrderConfirmView>() {

    @Inject
    lateinit var orderService: OrderService

    /*
        根据ID获取订单
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

    /*
        提交订单
     */
    fun submitOrder(order: Order) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        orderService.submitOrder(order).excute(object : BaseSubscriber<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                mView.onSubmitOrderResult(t)
            }
        }
//            , lifecycleProvider
        )

    }


}
