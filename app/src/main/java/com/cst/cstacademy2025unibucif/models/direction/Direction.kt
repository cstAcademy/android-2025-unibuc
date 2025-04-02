package com.cst.cstacademy2025unibucif.models.direction

sealed class Direction(
    open val id: Long,
    open val type: DirectionType
)

data class DirectionNorth(override val id: Long) : Direction(id, DirectionType.NORTH)
data class DirectionSouth(override val id: Long) : Direction(id, DirectionType.SOUTH)
data class DirectionEast(override val id: Long) : Direction(id, DirectionType.EAST)
data class DirectionWest(override val id: Long) : Direction(id, DirectionType.WEST)
data class DirectionUnknown(override val id: Long) : Direction(id, DirectionType.UNKNOWN)