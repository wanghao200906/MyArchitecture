package com.architecture.ordercenter.presenter

import com.architecture.baselibrary.ext.excute
import com.architecture.baselibrary.presenter.BasePresenter
import com.architecture.baselibrary.rx.BaseSubscriber
import com.architecture.ordercenter.data.protocol.ShipAddress
import com.architecture.ordercenter.presenter.view.ShipAddressView
import com.architecture.ordercenter.service.ShipAddressService
import javax.inject.Inject

/*
    收货人列表Presenter
 */
class ShipAddressPresenter @Inject constructor() : BasePresenter<ShipAddressView>() {

    @Inject
    lateinit var shipAddressService: ShipAddressService

    /*
        获取收货人列表
     */
    fun getShipAddressList() {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        shipAddressService.getShipAddressList().excute(object : BaseSubscriber<MutableList<ShipAddress>?>(mView) {
            override fun onNext(t: MutableList<ShipAddress>?) {
                mView.onGetShipAddressResult(t)
            }
        }
//            , lifecycleProvider
        )

    }

    /*
        设置默认收货人信息
     */
    fun setDefaultShipAddress(address:ShipAddress) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        shipAddressService.editShipAddress(address).excute(object : BaseSubscriber<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                mView.onSetDefaultResult(t)
            }
        }
//            , lifecycleProvider
        )

    }

    /*
        删除收货人信息
     */
    fun deleteShipAddress(id:Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        shipAddressService.deleteShipAddress(id).excute(object : BaseSubscriber<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                mView.onDeleteResult(t)
            }
        }
//            , lifecycleProvider
        )

    }

}
