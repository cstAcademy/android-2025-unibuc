package com.cst.cstacademy2025unibucif.networking.api

import com.cst.cstacademy2025unibucif.networking.models.LoginAPIRequestModel
import com.cst.cstacademy2025unibucif.networking.models.LoginAPIResponseModel
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthenticationAPIService {
    @POST("/api/login")
    @Headers("x-api-key: reqres-free-v1")
    suspend fun login(@Body loginAPIRequestModel: LoginAPIRequestModel) : LoginAPIResponseModel
}