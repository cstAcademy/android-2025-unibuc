package com.cst.cstacademy2025unibucif.data.repositories.directions

import com.cst.cstacademy2025unibucif.data.dao.DirectionsDAO
import com.cst.cstacademy2025unibucif.data.models.DirectionEntityModel

class DirectionsRepositoryLocal(private val dao: DirectionsDAO): DirectionsRepository {
    override suspend fun insertDirection(direction: DirectionEntityModel) = dao.insert(direction)
    override suspend fun getAllDirectionsWithCities() = dao.getDirectionsWithCities()
    override suspend fun getCitiesByDirection(id: Long) = dao.getDirectionWithCities(id)
}