package com.cst.cstacademy2025unibucif.ui.cities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.cst.cstacademy2025unibucif.R
import com.cst.cstacademy2025unibucif.data.models.CityEntityModel
import com.cst.cstacademy2025unibucif.data.models.DirectionEntityModel
import com.cst.cstacademy2025unibucif.data.repositories.CitiesRepository
import com.cst.cstacademy2025unibucif.data.repositories.DirectionsRepository
import com.cst.cstacademy2025unibucif.models.direction.DirectionType

class CitiesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cities, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.add_city).setOnClickListener {
            CitiesRepository.insertCity(getRandomCity(1))
        }

        view.findViewById<Button>(R.id.add_direction).setOnClickListener {
            val directionEntityModel = getRandomDirection(1)

            DirectionsRepository.insertDirection(directionEntityModel)
            CitiesRepository.insertCity(getRandomCity(1))
        }

        view.findViewById<Button>(R.id.get_all).setOnClickListener {
            DirectionsRepository.getAllDirectionsWithCities()
        }
    }

    private fun getRandomDirection(id: Long) : DirectionEntityModel {
        return DirectionEntityModel(
            id = id,
            type = DirectionType.entries.random()
        )
    }

    private fun getRandomCity(id: Long) : CityEntityModel {
        val cities = arrayListOf(
            CityEntityModel(ownerId = id, name = "Bucharest"),
            CityEntityModel(ownerId = id, name = "Barcelona"),
            CityEntityModel(ownerId = id, name = "Paris"),
            CityEntityModel(ownerId = id, name = "Berlin")
        )

        return cities.random()
    }
}