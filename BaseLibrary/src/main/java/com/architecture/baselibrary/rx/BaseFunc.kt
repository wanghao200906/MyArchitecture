package com.architecture.baselibrary.rx

import com.architecture.baselibrary.common.ResultCode
import com.architecture.baselibrary.data.protocol.BaseResp
import io.reactivex.Observable
import io.reactivex.functions.Function


/*
    通用数据类型转换封装
 */
class BaseFunc<T> : Function<BaseResp<T>, Observable<T>> {
    override fun apply(t: BaseResp<T>): Observable<T> {
        if (t.status != ResultCode.SUCCESS) {
            return Observable.error(BaseException(t.status, t.message))
        }

        return Observable.just(t.data)
    }
}