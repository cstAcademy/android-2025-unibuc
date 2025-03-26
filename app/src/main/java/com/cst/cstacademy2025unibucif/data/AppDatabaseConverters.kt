package com.cst.cstacademy2025unibucif.data

import androidx.room.TypeConverter
import com.cst.cstacademy2025unibucif.models.direction.DirectionType

class AppDatabaseConverters {
    @TypeConverter
    fun directionTypeToInt(directionType: DirectionType) : Int = directionType.id

    @TypeConverter
    fun intToDirectionType(id: Int) : DirectionType = DirectionType.getDirectionTypeById(id)
}
