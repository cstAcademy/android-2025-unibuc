package com.cst.cstacademy2025unibucif.helpers.extensions

import android.content.Context
import android.widget.Toast
import com.cst.cstacademy2025unibucif.BuildConfig

fun Context.showDebugToast(text: String) {
    if (BuildConfig.DEBUG) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}