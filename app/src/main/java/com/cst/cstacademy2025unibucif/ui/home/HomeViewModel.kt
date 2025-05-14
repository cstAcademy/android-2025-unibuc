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
class HomeViewModel @Inject constructor(): ViewModel() {

}