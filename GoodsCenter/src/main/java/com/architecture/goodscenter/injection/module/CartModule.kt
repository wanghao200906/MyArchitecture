package com.architecture.goodscenter.injection.module

import com.architecture.goodscenter.service.CartService
import com.architecture.goodscenter.service.impl.CartServiceImpl
import dagger.Module
import dagger.Provides

/*
    购物车Module
 */
@Module
class CartModule {

    @Provides
    fun provideCartservice(cartService: CartServiceImpl): CartService {
        return cartService
    }

}
