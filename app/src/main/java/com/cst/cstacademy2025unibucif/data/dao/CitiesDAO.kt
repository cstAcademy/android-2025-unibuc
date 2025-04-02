package com.cst.cstacademy2025unibucif.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.cst.cstacademy2025unibucif.data.models.CityEntityModel

@Dao
interface CitiesDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(city: CityEntityModel)
}