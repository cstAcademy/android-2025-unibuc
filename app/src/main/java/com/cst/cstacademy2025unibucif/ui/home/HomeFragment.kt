package com.cst.cstacademy2025unibucif.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cst.cstacademy2025unibucif.R
import com.cst.cstacademy2025unibucif.databinding.FragmentHomeBinding
import com.cst.cstacademy2025unibucif.managers.SharedPreferencesManager
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
    }

    override fun goToUsers() {
        val action = HomeFragmentDirections.actionHomeFragmentToUsersNavigation()

        findNavController().navigate(action)
    }

    override fun goToDirections() {
        val action = HomeFragmentDirections.actionHomeFragmentToDirectionsNavigation()

        findNavController().navigate(action)
    }

    override fun logout() {
        this.doLogout()
    }
}

interface HomeListener {
    fun goToUsers()
    fun goToDirections()
    fun logout()
}
