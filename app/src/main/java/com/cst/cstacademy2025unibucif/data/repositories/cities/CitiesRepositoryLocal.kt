package com.cst.cstacademy2025unibucif.data.repositories.cities

import com.cst.cstacademy2025unibucif.data.dao.CitiesDAO
import com.cst.cstacademy2025unibucif.data.models.CityEntityModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CitiesRepositoryLocal(private val dao: CitiesDAO): CitiesRepository {
    override fun insertCity(city: CityEntityModel) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insert(city)
        }
    }
}