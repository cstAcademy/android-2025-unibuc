package com.cst.cstacademy2025unibucif.models.direction

import com.cst.cstacademy2025unibucif.R

enum class DirectionType(val id: Int, val directionNameResId: Int, val directionDescriptionResId: Int) {
    NORTH(0, R.string.type_north, R.string.descr_north),
    SOUTH(1, R.string.type_south, R.string.descr_south),
    EAST(2, R.string.type_east, R.string.descr_east),
    WEST(3, R.string.type_west, R.string.descr_west),
    UNKNOWN(-1, R.string.type_unknown, R.string.descr_unknown);

    companion object {
        fun getDirectionTypeById(id: Int) = DirectionType.entries.find { it.id == id } ?: UNKNOWN
    }
}
