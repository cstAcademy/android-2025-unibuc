package com.cst.cstacademy2025unibucif.data.repositories.cities

import com.cst.cstacademy2025unibucif.data.models.CityEntityModel

interface CitiesRepository {
    fun insertCity(city: CityEntityModel)
}