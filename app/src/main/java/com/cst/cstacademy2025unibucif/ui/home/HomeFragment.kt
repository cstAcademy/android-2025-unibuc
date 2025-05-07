package com.cst.cstacademy2025unibucif.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cst.cstacademy2025unibucif.R
import com.cst.cstacademy2025unibucif.databinding.FragmentHomeBinding
import com.cst.cstacademy2025unibucif.models.direction.Direction
import com.cst.cstacademy2025unibucif.ui.DataBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : DataBindingFragment<FragmentHomeBinding>(), HomeListener {
    private val viewModel by viewModels<HomeViewModel>()

    override val layoutId: Int
        get() = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.listener = this

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
        val action = HomeFragmentDirections.actionHomeFragmentToCitiesFragment(direction.id)

        findNavController().navigate(action)
    }

    override fun goToUsers() {
        val action = HomeFragmentDirections.actionHomeFragmentToUsersNavigation()

        findNavController().navigate(action)
    }
}

interface HomeListener {
    fun goToUsers()
}
