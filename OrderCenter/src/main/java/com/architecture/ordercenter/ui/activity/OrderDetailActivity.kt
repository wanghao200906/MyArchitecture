package com.architecture.ordercenter.ui.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.architecture.baselibrary.ui.activity.BaseMvpActivity
import com.architecture.baselibrary.utils.YuanFenConverter
import com.architecture.ordercenter.R
import com.architecture.ordercenter.data.protocol.Order
import com.architecture.ordercenter.injection.component.DaggerOrderComponent
import com.architecture.ordercenter.injection.module.OrderModule
import com.architecture.ordercenter.presenter.OrderDetailPresenter
import com.architecture.ordercenter.presenter.view.OrderDetailView
import com.architecture.ordercenter.ui.adapter.OrderGoodsAdapter
import com.kotlin.provider.common.ProviderConstant
import com.kotlin.provider.router.RouterPath
import kotlinx.android.synthetic.main.activity_order_detail.*

/*
    订单详情
 */
@Route(path = RouterPath.MessageCenter.PATH_MESSAGE_ORDER)
class OrderDetailActivity : BaseMvpActivity<OrderDetailPresenter>(), OrderDetailView {
    private lateinit var mAdapter: OrderGoodsAdapter

    /*
        Dagger注册
     */
    override fun injectComponent() {
        DaggerOrderComponent.builder().activityComponent(mActivityComponent).orderModule(OrderModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail)

        initView()
        loadData()
    }

    /*
        初始化视图
     */
    private fun initView() {
        mOrderGoodsRv.layoutManager = LinearLayoutManager(this)
        mAdapter = OrderGoodsAdapter(this)
        mOrderGoodsRv.adapter = mAdapter
    }

    /*
        加载数据
     */
    private fun loadData() {
        mPresenter.getOrderById(intent.getIntExtra(ProviderConstant.KEY_ORDER_ID,-1))
    }

    /*
        获取订单回调
     */
    override fun onGetOrderByIdResult(result: Order) {
        mShipNameTv.setContentText(result.shipAddress!!.shipUserName)
        mShipMobileTv.setContentText(result.shipAddress!!.shipUserMobile)
        mShipAddressTv.setContentText(result.shipAddress!!.shipAddress)
        mTotalPriceTv.setContentText(YuanFenConverter.changeF2YWithUnit(result.totalPrice))

        mAdapter.setData(result.orderGoodsList)
    }

}
