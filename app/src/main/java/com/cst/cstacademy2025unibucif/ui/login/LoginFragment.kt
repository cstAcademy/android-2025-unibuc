package com.cst.cstacademy2025unibucif.ui.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cst.cstacademy2025unibucif.R
import com.cst.cstacademy2025unibucif.databinding.FragmentLoginBinding
import com.cst.cstacademy2025unibucif.ui.DataBindingFragment

class LoginFragment: DataBindingFragment<FragmentLoginBinding>(), LoginListener {
    private val viewModel by viewModels<LoginViewModel>()

    override val layoutId: Int
        get() = R.layout.fragment_login

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.listener = this

        setupObservables()
    }

    override fun goToRegisterFragment(email: String) {
        val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment(
            email = email
        )
        findNavController().navigate(action)
    }

    private fun goToHome() {
        val action = LoginFragmentDirections.actionLoginFragmentToHomeGraph()
        findNavController().navigate(action)
    }

    private fun setupObservables() {
        viewModel.isLoginFinished.observe(viewLifecycleOwner) { res ->
            goToHome() // ToDo: Handle token
        }
    }
}

interface LoginListener {
    fun goToRegisterFragment(email: String)
}