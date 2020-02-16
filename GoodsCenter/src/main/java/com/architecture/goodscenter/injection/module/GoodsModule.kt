package com.architecture.goodscenter.injection.module

import com.architecture.goodscenter.service.GoodsService
import com.architecture.goodscenter.service.impl.GoodsServiceImpl
import dagger.Module
import dagger.Provides

/*
    商品Module
 */
@Module
class GoodsModule {

    @Provides
    fun provideGoodservice(goodsService: GoodsServiceImpl): GoodsService {
        return goodsService
    }

}
