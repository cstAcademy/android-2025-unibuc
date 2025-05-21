package com.cst.cstacademy2025unibucif.networking.interceptors

import com.cst.cstacademy2025unibucif.managers.SharedPreferencesManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationTokenInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = SharedPreferencesManager.getAuthToken()
        val request = chain.request().newBuilder()

        request.addHeader(KEY_AUTHORIZATION, "$KEY_BEARER $token")

        return chain.proceed(request.build())
    }

    companion object {
        const val KEY_AUTHORIZATION = "Authorization"
        const val KEY_BEARER = "Bearer"
    }
}