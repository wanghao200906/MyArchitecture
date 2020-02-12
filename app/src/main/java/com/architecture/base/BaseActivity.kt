package com.architecture.base

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.architecture.App
import com.architecture.BR

/**
 * Created by Sven.Wong on 2020-02-10
 */


abstract class BaseActivity<DB : ViewDataBinding, VM : BaseViewModel>(private val mViewModelClass: Class<VM>) :
    AppCompatActivity() {
    protected var app: App = (applicationContext as App)

    @LayoutRes
    abstract fun getLayoutRes(): Int

    val binding by lazy {
        DataBindingUtil.setContentView(this, getLayoutRes()) as DB
    }

    val viewModel by lazy {
        ViewModelProviders.of(this).get(mViewModelClass)
    }

    /**
     * If you want to inject Dependency Injection
     * on your activity, you can override this.
     */
    open fun onInject() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        initBinding(viewModel)
        super.onCreate(savedInstanceState)
        onInject()
    }


    private fun initBinding(viewModel: VM) {
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }
}