package com.cst.cstacademy2025unibucif.ui.users

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cst.cstacademy2025unibucif.R
import com.cst.cstacademy2025unibucif.databinding.FragmentUsersBinding
import com.cst.cstacademy2025unibucif.ui.DataBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersFragment: DataBindingFragment<FragmentUsersBinding>() {
    private val viewModel by viewModels<UsersViewModel>()

    override val layoutId: Int
        get() = R.layout.fragment_users

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
    }
}
