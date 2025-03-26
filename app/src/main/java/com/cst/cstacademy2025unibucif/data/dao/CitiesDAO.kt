package com.cst.cstacademy2025unibucif.data.dao

import androidx.room.Dao
import androidx.room.Insert
import com.cst.cstacademy2025unibucif.data.models.CityEntityModel

@Dao
interface CitiesDAO {
    @Insert
    suspend fun insert(city: CityEntityModel)
}