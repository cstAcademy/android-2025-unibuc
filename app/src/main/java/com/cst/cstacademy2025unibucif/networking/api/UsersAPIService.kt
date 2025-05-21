package com.cst.cstacademy2025unibucif.networking.api

import com.cst.cstacademy2025unibucif.networking.models.users.UsersAPIResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersAPIService {
    @GET("/api/users")
    suspend fun get(@Query("page") page: Int): UsersAPIResponseModel
}
