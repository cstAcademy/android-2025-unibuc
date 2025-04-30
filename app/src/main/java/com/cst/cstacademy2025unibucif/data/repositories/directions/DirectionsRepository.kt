package com.cst.cstacademy2025unibucif.data.repositories.directions

import com.cst.cstacademy2025unibucif.data.models.DirectionEntityModel
import com.cst.cstacademy2025unibucif.data.models.DirectionWithCitiesEntityModel

interface DirectionsRepository {
    suspend fun insertDirection(direction: DirectionEntityModel)
    suspend fun getAllDirectionsWithCities(): List<DirectionWithCitiesEntityModel>
    suspend fun getCitiesByDirection(id: Long): DirectionWithCitiesEntityModel
}