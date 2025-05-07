package com.cst.cstacademy2025unibucif.data.repositories.users

import com.cst.cstacademy2025unibucif.data.dao.UsersDAO
import com.cst.cstacademy2025unibucif.models.users.UserModel

class UsersRepositoryLocal(val dao: UsersDAO): UsersRepository {
    override suspend fun insert(users: List<UserModel>) = dao.insert(users)
    override suspend fun getAll(): List<UserModel> = dao.getAll()
}
