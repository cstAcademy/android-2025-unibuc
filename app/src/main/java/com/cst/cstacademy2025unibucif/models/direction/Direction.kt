package com.cst.cstacademy2025unibucif.models.direction

sealed class Direction(
    open val id: Int,
    open val type: DirectionType
)

data class DirectionNorth(override val id: Int) : Direction(id, DirectionType.NORTH)
data class DirectionSouth(override val id: Int) : Direction(id, DirectionType.SOUTH)
data class DirectionEast(override val id: Int) : Direction(id, DirectionType.EAST)
data class DirectionWest(override val id: Int) : Direction(id, DirectionType.WEST)
data class DirectionUnknown(override val id: Int) : Direction(id, DirectionType.UNKNOWN)