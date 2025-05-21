package com.cst.cstacademy2025unibucif.networking.client

import com.cst.cstacademy2025unibucif.BuildConfig
import com.cst.cstacademy2025unibucif.networking.interceptors.AuthenticationTokenInterceptor
import com.cst.cstacademy2025unibucif.networking.interceptors.ReqresAuthInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val logging = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    private val authentication = AuthenticationTokenInterceptor()
    private val reqres = ReqresAuthInterceptor()

    private val authClient = OkHttpClient.Builder()
        .addInterceptor(authentication)
        .addInterceptor(reqres)
        .addInterceptor(logging)
        .build()

    private val noAuthClient = OkHttpClient.Builder()
        .addInterceptor(reqres)
        .addInterceptor(logging)
        .build()

    val authInstance = Retrofit.Builder()
        .baseUrl(BuildConfig.ENVIRONMENT)
        .client(authClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val noAuthInstance = Retrofit.Builder()
        .baseUrl(BuildConfig.ENVIRONMENT)
        .client(noAuthClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}