package com.cst.cstacademy2025unibucif.models.direction

import com.cst.cstacademy2025unibucif.R

enum class DirectionType(val id: Int, val directionNameResId: Int) {
    NORTH(0, R.string.type_north),
    SOUTH(1, R.string.type_south),
    EAST(2, R.string.type_east),
    WEST(3, R.string.type_west)
}

