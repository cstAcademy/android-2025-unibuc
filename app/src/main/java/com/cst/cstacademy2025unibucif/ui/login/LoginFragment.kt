package com.cst.cstacademy2025unibucif.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cst.cstacademy2025unibucif.R

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

    private fun doLogin() {
        val action = LoginFragmentDirections.actionLoginFragmentToHomeGraph()
        findNavController().navigate(action)
    }

}