package com.cst.cstacademy2025unibucif.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cst.cstacademy2025unibucif.R
import com.cst.cstacademy2025unibucif.adapters.DirectionsAdapter
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
            DirectionNorth(0), DirectionSouth(1), DirectionEast(2), DirectionWest(3),
            DirectionNorth(0), DirectionSouth(1), DirectionEast(2), DirectionWest(3),
            DirectionNorth(0), DirectionSouth(1), DirectionEast(2), DirectionWest(3),
            DirectionNorth(0), DirectionSouth(1), DirectionEast(2), DirectionWest(3),
            DirectionNorth(0), DirectionSouth(1), DirectionEast(2), DirectionWest(3),
            DirectionNorth(0), DirectionSouth(1), DirectionEast(2), DirectionWest(3),
            DirectionNorth(0), DirectionSouth(1), DirectionEast(2), DirectionWest(3),
            DirectionNorth(0), DirectionSouth(1), DirectionEast(2), DirectionWest(3),
            DirectionNorth(0), DirectionSouth(1), DirectionEast(2), DirectionWest(3),
            DirectionNorth(0), DirectionSouth(1), DirectionEast(2), DirectionWest(3),
            DirectionNorth(0), DirectionSouth(1), DirectionEast(2), DirectionWest(3),
            DirectionNorth(0), DirectionSouth(1), DirectionEast(2), DirectionWest(3),
        )

        val adapter = DirectionsAdapter(directions.shuffled())
//        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//        val layoutManager = GridLayoutManager(context, 3)
        val layoutManager = GridLayoutManager(context, 6)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (position) {
                    0, 1, 2 -> 2
                    3, 4 -> 3
                    5 -> 6
                    else -> 2
                }
            }
        }

        recyclerView.apply {
            this.adapter = adapter
            this.layoutManager = layoutManager
        }
    }
}