package com.cst.cstacademy2025unibucif.networking.api

import com.cst.cstacademy2025unibucif.networking.models.login.LoginAPIRequestModel
import com.cst.cstacademy2025unibucif.networking.models.login.LoginAPIResponseModel
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationAPIService {
    @POST("/api/login")
    suspend fun login(@Body loginAPIRequestModel: LoginAPIRequestModel) : LoginAPIResponseModel
}