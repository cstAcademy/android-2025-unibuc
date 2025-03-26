package com.cst.cstacademy2025unibucif.data.repositories

import com.cst.cstacademy2025unibucif.ApplicationController
import com.cst.cstacademy2025unibucif.data.models.CityEntityModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object CitiesRepository {
    fun insertCity(city: CityEntityModel) {
        CoroutineScope(Dispatchers.IO).launch {
            ApplicationController.instance?.appDatabase?.citiesDAO?.insert(city)
        }
    }
}