package com.cst.cstacademy2025unibucif.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cst.cstacademy2025unibucif.data.dao.CitiesDAO
import com.cst.cstacademy2025unibucif.data.dao.DirectionsDAO
import com.cst.cstacademy2025unibucif.data.models.CityEntityModel
import com.cst.cstacademy2025unibucif.data.models.DirectionEntityModel

@Database(
    entities = [
        CityEntityModel::class,
        DirectionEntityModel::class
    ],
    version = 2
)
@TypeConverters(AppDatabaseConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val citiesDAO : CitiesDAO
    abstract val directionsDAO : DirectionsDAO
}
