package com.cst.cstacademy2025unibucif.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.cst.cstacademy2025unibucif.R
import com.cst.cstacademy2025unibucif.databinding.FragmentLoginBinding
import com.cst.cstacademy2025unibucif.helpers.extensions.isEmailValid
import com.cst.cstacademy2025unibucif.helpers.extensions.isPasswordValid
import com.cst.cstacademy2025unibucif.helpers.extensions.logErrorMessage
import com.cst.cstacademy2025unibucif.helpers.extensions.showDebugToast
import com.cst.cstacademy2025unibucif.networking.repositories.AuthenticationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class LoginFragment: Fragment(), LoginListener {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
//    private val viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.listener = this
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
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

    override fun doLogin(email: String, password: String) {
        viewModel.email.set("test2@email.com")

        return

        if (!email.isEmailValid() || !password.isPasswordValid()) {
            context?.showDebugToast("Invalid credentials")

            return
        }

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val res = withContext(Dispatchers.IO) {
                    AuthenticationRepository.doLogin(email, password)
                }

                res.token.logErrorMessage()
            } catch (e: IOException) {
                context?.showDebugToast("Please check your internet connection")
            } catch (e: HttpException) {
                context?.showDebugToast("Server error: ${e.code()}")
            } catch (e: Exception) {
                context?.showDebugToast("Unexpected error: ${e.localizedMessage}")
            }
        }
    }
}

interface LoginListener {
    fun doLogin(email: String, password: String)
    fun goToRegisterFragment(email: String)
}