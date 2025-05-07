package com.cst.cstacademy2025unibucif.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cst.cstacademy2025unibucif.data.dao.CitiesDAO
import com.cst.cstacademy2025unibucif.data.dao.DirectionsDAO
import com.cst.cstacademy2025unibucif.data.dao.UsersDAO
import com.cst.cstacademy2025unibucif.data.models.CityEntityModel
import com.cst.cstacademy2025unibucif.data.models.DirectionEntityModel
import com.cst.cstacademy2025unibucif.models.users.UserModel

@Database(
    entities = [
        CityEntityModel::class,
        DirectionEntityModel::class,
        UserModel::class
    ],
    version = 3
)
@TypeConverters(AppDatabaseConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val citiesDAO : CitiesDAO
    abstract val directionsDAO : DirectionsDAO
    abstract val usersDao: UsersDAO
}
