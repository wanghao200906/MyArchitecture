package com.architecture.utils.extensions

import android.app.Activity
import android.support.v7.app.AlertDialog
import android.widget.Toast

/**
 * Created by Sven.Wong on 2020-02-11
 */


fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, message, duration).show()

inline fun Activity.alertDialog(body: AlertDialog.Builder.() -> AlertDialog.Builder): AlertDialog {
    return AlertDialog.Builder(this)
        .body()
        .show()
}