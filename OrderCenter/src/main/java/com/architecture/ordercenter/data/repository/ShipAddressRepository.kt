package com.architecture.ordercenter.data.repository

import com.architecture.baselibrary.data.net.RetrofitFactory
import com.architecture.baselibrary.data.protocol.BaseResp
import com.architecture.ordercenter.data.api.ShipAddressApi
import com.architecture.ordercenter.data.protocol.AddShipAddressReq
import com.architecture.ordercenter.data.protocol.DeleteShipAddressReq
import com.architecture.ordercenter.data.protocol.EditShipAddressReq
import com.architecture.ordercenter.data.protocol.ShipAddress
import io.reactivex.Observable
import javax.inject.Inject


/*
   收货地址数据层
 */
class ShipAddressRepository @Inject constructor() {

    /*
        添加收货地址
     */
    fun addShipAddress(shipUserName: String, shipUserMobile: String, shipAddress: String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(ShipAddressApi::class.java).addShipAddress(
            AddShipAddressReq(shipUserName,shipUserMobile,shipAddress)
        )
    }

    /*
        删除收货地址
     */
    fun deleteShipAddress(id: Int): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(ShipAddressApi::class.java).deleteShipAddress(
            DeleteShipAddressReq(id)
        )
    }

    /*
        修改收货地址
     */
    fun editShipAddress(address: ShipAddress): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(ShipAddressApi::class.java).editShipAddress(
            EditShipAddressReq(address.id,address.shipUserName,address.shipUserMobile,address.shipAddress,address.shipIsDefault)
        )
    }

    /*
        获取收货地址列表
     */
    fun getShipAddressList(): Observable<BaseResp<MutableList<ShipAddress>?>> {
        return RetrofitFactory.instance.create(ShipAddressApi::class.java).getShipAddressList()
    }

}
