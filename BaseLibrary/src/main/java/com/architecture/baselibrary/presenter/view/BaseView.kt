package com.architecture.baselibrary.presenter.view

/**
 * Created by Sven.Wong on 2020-02-13
 */

interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError(text: String)
}