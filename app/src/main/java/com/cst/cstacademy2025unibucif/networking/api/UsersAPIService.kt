package com.cst.cstacademy2025unibucif.networking.api

import com.cst.cstacademy2025unibucif.networking.models.users.UsersAPIResponseModel
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UsersAPIService {
    @GET("/api/users")
    @Headers("x-api-key: reqres-free-v1")
    suspend fun get(@Query("page") page: Int): UsersAPIResponseModel
}
