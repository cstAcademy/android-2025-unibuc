package com.cst.cstacademy2025unibucif.networking.repositories

import com.cst.cstacademy2025unibucif.networking.api.UsersAPIService
import com.cst.cstacademy2025unibucif.networking.client.RetrofitClient

object UsersRepository {
    private val retrofitService: UsersAPIService by lazy {
        RetrofitClient.instance.create(UsersAPIService::class.java)
    }

    suspend fun get(page: Int) = retrofitService.get(page)
}
