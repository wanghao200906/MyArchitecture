package com.architecture.baselibrary.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.FrameLayout
import com.architecture.baselibrary.common.AppManager
import org.jetbrains.anko.find

/**
 * Created by Sven.Wong on 2020-02-13
 */

/*
    Activity基类，业务无关
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActivity(this)
    }

    //获取Window中视图content
//    跟实图就是FramenLayout id就是android.R.id.content
    val contentView: View
        get() {
            val content = find<FrameLayout>(android.R.id.content)
            return content.getChildAt(0)
        }
}
