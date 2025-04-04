package com.cst.cstacademy2025unibucif.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cst.cstacademy2025unibucif.R
import com.cst.cstacademy2025unibucif.adapters.DirectionsAdapter
import com.cst.cstacademy2025unibucif.data.models.DirectionEntityModel
import com.cst.cstacademy2025unibucif.data.repositories.DirectionsRepository
import com.cst.cstacademy2025unibucif.models.direction.Direction
import com.cst.cstacademy2025unibucif.models.direction.DirectionEast
import com.cst.cstacademy2025unibucif.models.direction.DirectionNorth
import com.cst.cstacademy2025unibucif.models.direction.DirectionSouth
import com.cst.cstacademy2025unibucif.models.direction.DirectionWest

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_directions)
        val directions = arrayListOf(
            DirectionNorth(0), DirectionSouth(1), DirectionEast(2), DirectionWest(3)
        )

        val adapter = DirectionsAdapter(directions.shuffled()) { direction ->
            insertDirectionToDb(direction)
        }
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        recyclerView.apply {
            this.adapter = adapter
            this.layoutManager = layoutManager
        }
    }

    private fun goToCities(direction: Direction) {
        val action = HomeFragmentDirections.actionHomeFragmentToCitiesFragment(direction.id)

        findNavController().navigate(action)
    }

    private fun insertDirectionToDb(direction: Direction) {
        val directionEntity = DirectionEntityModel(direction.id, direction.type)

        DirectionsRepository.insertDirection(directionEntity) {
            goToCities(direction)
        }
    }
}