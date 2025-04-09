package com.cst.cstacademy2025unibucif.helpers.extensions

import android.text.TextUtils
import android.util.Patterns

fun String.isEmailValid() = !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()
fun String.isPasswordValid() = this.length > 3