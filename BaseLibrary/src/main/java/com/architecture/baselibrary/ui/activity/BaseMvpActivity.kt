package com.architecture.baselibrary.ui.activity

import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.architecture.baselibrary.common.BaseApplication
import com.architecture.baselibrary.injection.component.ActivityComponent
import com.architecture.baselibrary.injection.component.DaggerActivityComponent
import com.architecture.baselibrary.injection.module.ActivityModule
import com.architecture.baselibrary.presenter.BasePresenter
import com.architecture.baselibrary.presenter.view.BaseView
import com.architecture.baselibrary.widgets.ProgressLoading
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by Sven.Wong on 2020-02-13
 */

abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    //Presenter泛型，Dagger注入
    @Inject
    lateinit var mPresenter: T

    lateinit var mActivityComponent: ActivityComponent

    private lateinit var mLoadingDialog: ProgressLoading

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()

        //初始加载框
        mLoadingDialog = ProgressLoading.create(this)
        //ARouter注册
        ARouter.getInstance().inject(this)
    }

    /*
        Dagger注册
     */
    protected abstract fun injectComponent()

    /*
        初始Activity Component
     */
    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder()
            .appComponent((application as BaseApplication).appComponent)
            .activityModule(ActivityModule(this))
//            .lifecycleProviderModule(LifecycleProviderModule(this))
            .build()

    }

    /*
        显示加载框，默认实现
     */
    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    /*
        隐藏加载框，默认实现
     */
    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    /*
        错误信息提示，默认实现
     */
    override fun onError(text: String) {
        toast(text)
    }
}