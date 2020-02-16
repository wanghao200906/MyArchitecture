package com.architecture.goodscenter.service.impl

import com.architecture.baselibrary.ext.convert
import com.architecture.goodscenter.data.protocol.Goods
import com.architecture.goodscenter.data.repository.GoodsRepository
import com.architecture.goodscenter.service.GoodsService
import io.reactivex.Observable
import javax.inject.Inject

/*
    商品 业务层 实现类
 */
class GoodsServiceImpl @Inject constructor(): GoodsService {

    @Inject
    lateinit var repository: GoodsRepository

    /*
        获取商品列表
     */
    override fun getGoodsList(categoryId: Int, pageNo: Int): Observable<MutableList<Goods>?> {
        return repository.getGoodsList(categoryId,pageNo).convert()
    }

    /*
        根据关键字查询商品
     */
    override fun getGoodsListByKeyword(keyword: String, pageNo: Int): Observable<MutableList<Goods>?> {
        return repository.getGoodsListByKeyword(keyword,pageNo).convert()
    }

    /*
        获取商品详情
     */
    override fun getGoodsDetail(goodsId: Int): Observable<Goods> {
        return repository.getGoodsDetail(goodsId).convert()
    }
}
