package com.cst.cstacademy2025unibucif.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cst.cstacademy2025unibucif.data.models.DirectionEntityModel
import com.cst.cstacademy2025unibucif.data.models.DirectionWithCitiesEntityModel

@Dao
interface DirectionsDAO {
    @Insert
    suspend fun insert(direction: DirectionEntityModel)

    @Query("""
        SELECT * 
        FROM DirectionEntityModel
    """)
    suspend fun getDirectionsWithCities() : List<DirectionWithCitiesEntityModel>
}
