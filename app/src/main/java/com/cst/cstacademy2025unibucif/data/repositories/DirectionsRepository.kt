package com.cst.cstacademy2025unibucif.data.repositories

import com.cst.cstacademy2025unibucif.ApplicationController
import com.cst.cstacademy2025unibucif.data.models.DirectionEntityModel
import com.cst.cstacademy2025unibucif.helpers.extensions.logErrorMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object DirectionsRepository {
    fun insertDirection(direction: DirectionEntityModel) {
        CoroutineScope(Dispatchers.IO).launch {
            ApplicationController.instance?.appDatabase?.directionsDAO?.insert(direction)
        }
    }

    fun getAllDirectionsWithCities() {
        CoroutineScope(Dispatchers.IO).launch {
            val res = ApplicationController.instance?.appDatabase?.directionsDAO?.getDirectionsWithCities()

            res.toString().logErrorMessage()
        }
    }
}