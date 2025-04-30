package com.cst.cstacademy2025unibucif.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cst.cstacademy2025unibucif.adapters.DirectionsAdapter
import com.cst.cstacademy2025unibucif.data.models.DirectionEntityModel
import com.cst.cstacademy2025unibucif.data.repositories.directions.DirectionsRepository
import com.cst.cstacademy2025unibucif.models.direction.Direction
import com.cst.cstacademy2025unibucif.models.direction.DirectionEast
import com.cst.cstacademy2025unibucif.models.direction.DirectionNorth
import com.cst.cstacademy2025unibucif.models.direction.DirectionSouth
import com.cst.cstacademy2025unibucif.models.direction.DirectionWest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val directionsRepository: DirectionsRepository
): ViewModel() {
    private val _isInsertFinished = MutableLiveData<Direction>()
    val isInsertFinished: LiveData<Direction>
        get() = _isInsertFinished

    private val directions = arrayListOf(
        DirectionNorth(0), DirectionSouth(1), DirectionEast(2), DirectionWest(3)
    )

    val adapter = DirectionsAdapter(directions.shuffled()) { direction ->
        insertDirectionToDb(direction)
    }

    private fun insertDirectionToDb(direction: Direction) {
        val directionEntity = DirectionEntityModel(direction.id, direction.type)

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                directionsRepository.insertDirection(directionEntity)
            }

            _isInsertFinished.value = direction
        }
    }
}