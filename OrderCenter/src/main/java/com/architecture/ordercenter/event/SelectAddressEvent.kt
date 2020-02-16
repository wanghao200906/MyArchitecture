package com.architecture.ordercenter.event

import com.architecture.ordercenter.data.protocol.ShipAddress


/*
    选择收货人信息事件
 */
class SelectAddressEvent(val address: ShipAddress)
