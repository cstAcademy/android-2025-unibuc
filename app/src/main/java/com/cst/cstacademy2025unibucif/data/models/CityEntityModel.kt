package com.cst.cstacademy2025unibucif.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CityEntityModel (
    @PrimaryKey(true)
    val id: Long = 0,

    @ColumnInfo(name = OWNER_ID)
    val ownerId: Long,

    val name: String
) {
    companion object {
        const val OWNER_ID = "ownerId"
    }
}