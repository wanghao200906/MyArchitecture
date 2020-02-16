package com.architecture.baselibrary.rx

import com.architecture.baselibrary.presenter.view.BaseView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/*
    Rx订阅者默认实现
 */
open class BaseSubscriber<T>(val baseView: BaseView) : Observer<T> {
    override fun onNext(t: T) {
    }


    override fun onComplete() {
        baseView.hideLoading()
    }

    override fun onError(e: Throwable) {
        baseView.hideLoading()
        if (e is BaseException) {
            baseView.onError(e.msg)
        }
    }

    override fun onSubscribe(d: Disposable) {
    }


}
