package com.cst.cstacademy2025unibucif.networking.interceptors

import com.cst.cstacademy2025unibucif.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ReqresAuthInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()

        request.addHeader(KEY_API_KEY, BuildConfig.REQRES_API_KEY)

        return chain.proceed(request.build())
    }

     companion object {
         const val KEY_API_KEY = "x-api-key"
     }
}