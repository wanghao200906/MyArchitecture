package com.architecture.ordercenter.injection.module

import com.architecture.ordercenter.service.OrderService
import com.architecture.ordercenter.service.impl.OrderServiceImpl
import dagger.Module
import dagger.Provides

/*
    订单Module
 */
@Module
class OrderModule {

    @Provides
    fun provideOrderservice(orderService: OrderServiceImpl): OrderService {
        return orderService
    }

}
