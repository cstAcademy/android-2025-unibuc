package com.cst.cstacademy2025unibucif.networking.repositories

import com.cst.cstacademy2025unibucif.networking.api.AuthenticationAPIService
import com.cst.cstacademy2025unibucif.networking.client.RetrofitClient
import com.cst.cstacademy2025unibucif.networking.models.LoginAPIRequestModel
import com.cst.cstacademy2025unibucif.networking.models.LoginAPIResponseModel

object AuthenticationRepository {
    private val retrofitService: AuthenticationAPIService by lazy {
        RetrofitClient.instance.create(AuthenticationAPIService::class.java)
    }

    suspend fun doLogin(email: String, password: String) : LoginAPIResponseModel {
        val model = LoginAPIRequestModel(email, password)

        return retrofitService.login(model)
    }
}