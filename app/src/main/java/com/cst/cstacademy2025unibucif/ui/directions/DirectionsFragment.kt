package com.cst.cstacademy2025unibucif.ui.directions

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cst.cstacademy2025unibucif.R
import com.cst.cstacademy2025unibucif.databinding.FragmentDirectionsBinding
import com.cst.cstacademy2025unibucif.models.direction.Direction
import com.cst.cstacademy2025unibucif.ui.DataBindingFragment
import com.cst.cstacademy2025unibucif.ui.home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DirectionsFragment(
    override val layoutId: Int = R.layout.fragment_directions
): DataBindingFragment<FragmentDirectionsBinding>() {
    private val viewModel by viewModels<DirectionsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel

        setupObservables()
    }

    private fun setupObservables() {
        viewModel.isInsertFinished.observe(viewLifecycleOwner) { direction ->
            direction?.apply {
                goToCities(this)
            }
        }
    }

    private fun goToCities(direction: Direction) {
        val action = DirectionsFragmentDirections.actionDirectionsFragmentToCitiesFragment(direction.id)

        findNavController().navigate(action)
    }
}