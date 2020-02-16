package com.architecture.paysdk.injection.module

import com.architecture.paysdk.service.PayService
import com.architecture.paysdk.service.impl.PayServiceImpl
import dagger.Module
import dagger.Provides

/*
    支付 Module
 */
@Module
class PayModule {

    @Provides
    fun providePayService(payService: PayServiceImpl): PayService {
        return payService
    }

}
