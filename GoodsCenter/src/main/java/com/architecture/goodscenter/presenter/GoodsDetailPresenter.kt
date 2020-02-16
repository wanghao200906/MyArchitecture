package com.architecture.goodscenter.presenter

import com.architecture.baselibrary.ext.excute
import com.architecture.baselibrary.presenter.BasePresenter
import com.architecture.baselibrary.rx.BaseSubscriber
import com.architecture.baselibrary.utils.AppPrefsUtils
import com.architecture.goodscenter.common.GoodsConstant
import com.architecture.goodscenter.data.protocol.Goods
import com.architecture.goodscenter.presenter.view.GoodsDetailView
import com.architecture.goodscenter.service.CartService
import com.architecture.goodscenter.service.GoodsService
import javax.inject.Inject

/*
    商品详情 Presenter
 */
class GoodsDetailPresenter @Inject constructor() : BasePresenter<GoodsDetailView>() {

    @Inject
    lateinit var goodsService: GoodsService

    @Inject
    lateinit var cartService: CartService

    /*
        获取商品详情
     */
    fun getGoodsDetailList(goodsId: Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        goodsService.getGoodsDetail(goodsId).excute(object : BaseSubscriber<Goods>(mView) {
            override fun onNext(t: Goods) {
                    mView.onGetGoodsDetailResult(t)
            }
        }
//            , lifecycleProvider
        )

    }

    /*
        加入购物车
     */
    fun addCart(goodsId: Int, goodsDesc: String, goodsIcon: String, goodsPrice: Long,
                           goodsCount: Int, goodsSku: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        cartService.addCart(goodsId,goodsDesc,goodsIcon,goodsPrice,
                goodsCount,goodsSku).excute(object : BaseSubscriber<Int>(mView) {
            override fun onNext(t: Int) {
                AppPrefsUtils.putInt(GoodsConstant.SP_CART_SIZE,t)
                mView.onAddCartResult(t)
            }
        }
//            , lifecycleProvider
        )

    }

}
