package com.cst.cstacademy2025unibucif.ui.login

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val email = ObservableField("")
    val password = ObservableField("")
}