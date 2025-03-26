package com.cst.cstacademy2025unibucif.data.models

import androidx.room.Embedded
import androidx.room.Relation

data class DirectionWithCitiesEntityModel(
    @Embedded
    val direction: DirectionEntityModel,

    @Relation(
        parentColumn = DirectionEntityModel.ID,
        entityColumn = CityEntityModel.OWNER_ID
    )
    val cities: List<CityEntityModel>
)