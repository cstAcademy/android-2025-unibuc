package com.cst.cstacademy2025unibucif.data.repositories

import com.cst.cstacademy2025unibucif.ApplicationController
import com.cst.cstacademy2025unibucif.data.models.CityEntityModel
import com.cst.cstacademy2025unibucif.data.models.DirectionEntityModel
import com.cst.cstacademy2025unibucif.data.models.DirectionWithCitiesEntityModel
import com.cst.cstacademy2025unibucif.helpers.extensions.logErrorMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object DirectionsRepository {
    fun insertDirection(direction: DirectionEntityModel, onFinish : () -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            ApplicationController.instance?.appDatabase?.directionsDAO?.insert(direction)

            withContext(Dispatchers.Main) {
                onFinish()
            }
        }
    }

    fun getAllDirectionsWithCities() {
        CoroutineScope(Dispatchers.IO).launch {
            val res = ApplicationController.instance?.appDatabase?.directionsDAO?.getDirectionsWithCities()

            res.toString().logErrorMessage()
        }
    }

    fun getCitiesByDirection(id: Long, onFinish : (DirectionWithCitiesEntityModel?) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val res = ApplicationController.instance?.appDatabase?.directionsDAO?.getDirectionWithCities(id)

            withContext(Dispatchers.Main) {
                onFinish(res)
            }
        }
    }
}