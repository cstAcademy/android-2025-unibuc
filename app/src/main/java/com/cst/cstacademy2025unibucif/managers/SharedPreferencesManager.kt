package com.cst.cstacademy2025unibucif.managers

import android.content.Context
import com.cst.cstacademy2025unibucif.ApplicationController

object SharedPreferencesManager {
    private val sharedPreferences by lazy {
        ApplicationController.instance?.getSharedPreferences(
            Arguments.FILENAME, Context.MODE_PRIVATE)
    }

    object Arguments {
        const val KEY_AUTH_TOKEN = "key_auth_token"
        const val FILENAME = "filename"
    }

    fun getAuthToken(): String? {
        return sharedPreferences?.getString(Arguments.KEY_AUTH_TOKEN, null)
    }

    fun setAuthToken(token: String) {
        with(sharedPreferences?.edit()) {
            this?.putString(Arguments.KEY_AUTH_TOKEN, token)?.apply()
        }
    }

    fun removeAuthToken() {
        with(sharedPreferences?.edit()) {
            this?.remove(Arguments.KEY_AUTH_TOKEN)?.apply()
        }
    }
}