package com.cst.cstacademy2025unibucif.data.repositories.users

import com.cst.cstacademy2025unibucif.models.users.UserModel

interface UsersRepository {
    suspend fun insert(users: List<UserModel>)
    suspend fun getAll(): List<UserModel>
}
