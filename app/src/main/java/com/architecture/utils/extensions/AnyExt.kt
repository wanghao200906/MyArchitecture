package com.architecture.utils.extensions
import android.util.Log

/**
 * Created by Sven.Wong on 2020-02-11
 */



fun Any.logE(message: String) = Log.e(this::class.java.simpleName, message)

fun Any.logD(message: String) = Log.d(this::class.java.simpleName, message)

fun Any.logV(message: String) = Log.v(this::class.java.simpleName, message)

fun Any.logW(message: String) = Log.w(this::class.java.simpleName, message)

fun Any.logI(message: String) = Log.i(this::class.java.simpleName, message)

fun Any.emptyString() = ""