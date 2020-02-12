package com.architecture.utils

import android.app.ActivityManager
import android.content.Context

/**
 * Created by Sven.Wong on 2020-02-11
 */

object SystemUtils {
    fun getProcessName(cxt: Context, pid: Int): String? {
        val am =
            cxt.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val runningApps = am.runningAppProcesses ?: return null
        for (procInfo in runningApps) {
            if (procInfo.pid == pid) {
                return procInfo.processName
            }
        }
        return null
    }

    fun asdf() {

    }
}
