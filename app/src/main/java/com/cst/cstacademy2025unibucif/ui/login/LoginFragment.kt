package com.cst.cstacademy2025unibucif.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.cst.cstacademy2025unibucif.R
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

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.tv_register).setOnClickListener {
            val email = view.findViewById<EditText>(R.id.edt_email).text.toString()
            goToRegisterFragment(email)
        }

        view.findViewById<TextView>(R.id.btn_login).setOnClickListener {
            doLogin()
        }
    }

    private fun goToRegisterFragment(email: String) {
        val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment(
            email = email
        )
        findNavController().navigate(action)
    }

    private fun goToHome() {
        val action = LoginFragmentDirections.actionLoginFragmentToHomeGraph()
        findNavController().navigate(action)
    }

    private fun doLogin() {
        val email = view?.findViewById<AppCompatEditText>(R.id.edt_email)?.text?.toString() ?: ""
        val password = view?.findViewById<AppCompatEditText>(R.id.edt_password)?.text?.toString() ?: ""

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