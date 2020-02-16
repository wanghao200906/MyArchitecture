package com.architecture.goodscenter.presenter
import com.architecture.baselibrary.ext.excute
import com.architecture.baselibrary.presenter.BasePresenter
import com.architecture.baselibrary.rx.BaseSubscriber
import com.architecture.goodscenter.data.protocol.Goods
import com.architecture.goodscenter.presenter.view.GoodsListView
import com.architecture.goodscenter.service.GoodsService
import javax.inject.Inject

/*
    商品列表 Presenter
 */
class GoodsListPresenter @Inject constructor() : BasePresenter<GoodsListView>() {

    @Inject
    lateinit var goodsService: GoodsService


    /*
        获取商品列表
     */
    fun getGoodsList(categoryId: Int, pageNo: Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        goodsService.getGoodsList(categoryId,pageNo).excute(object : BaseSubscriber<MutableList<Goods>?>(mView) {
            override fun onNext(t: MutableList<Goods>?) {
                    mView.onGetGoodsListResult(t)
            }
        }
//            , lifecycleProvider
        )

    }

    /*
        根据关键字 搜索商品
     */
    fun getGoodsListByKeyword(keyword: String, pageNo: Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        goodsService.getGoodsListByKeyword(keyword,pageNo).excute(object : BaseSubscriber<MutableList<Goods>?>(mView) {
            override fun onNext(t: MutableList<Goods>?) {
                mView.onGetGoodsListResult(t)
            }
        }
//            , lifecycleProvider
        )

    }

}
