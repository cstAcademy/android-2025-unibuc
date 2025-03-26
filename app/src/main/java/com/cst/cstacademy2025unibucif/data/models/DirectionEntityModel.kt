package com.cst.cstacademy2025unibucif.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cst.cstacademy2025unibucif.models.direction.DirectionType

@Entity
data class DirectionEntityModel(
    @PrimaryKey
    @ColumnInfo(name = ID)
    val id: Long,

    val type: DirectionType
) {
    companion object {
        const val ID = "id"
    }
}