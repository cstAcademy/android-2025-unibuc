package com.cst.cstacademy2025unibucif.ui.login

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cst.cstacademy2025unibucif.BuildConfig
import com.cst.cstacademy2025unibucif.helpers.extensions.isEmailValid
import com.cst.cstacademy2025unibucif.helpers.extensions.isPasswordValid
import com.cst.cstacademy2025unibucif.helpers.extensions.logErrorMessage
import com.cst.cstacademy2025unibucif.networking.models.login.LoginAPIResponseModel
import com.cst.cstacademy2025unibucif.networking.repositories.AuthenticationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class LoginViewModel : ViewModel() {
    val email = ObservableField("")
    val password = ObservableField("")
    val isEmailError = ObservableField(false)
    val isPasswordError = ObservableField(false)

    private val _isLoginFinished = MutableLiveData<LoginAPIResponseModel>()
    val isLoginFinished: LiveData<LoginAPIResponseModel>
        get() = _isLoginFinished

    init {
        if (BuildConfig.DEBUG) {
            email.set("eve.holt@reqres.in")
            password.set("cityslicka")
        }
    }

    fun doLogin(email: String, password: String) {
        isEmailError.set(false)
        isPasswordError.set(false)

        if (!email.isEmailValid()) {
            isEmailError.set(true)

            return
        }

        if (!password.isPasswordValid()) {
            isPasswordError.set(true)

            return
        }

        viewModelScope.launch {
            try {
                val res = withContext(Dispatchers.IO) {
                    AuthenticationRepository.doLogin(email, password)
                }

                _isLoginFinished.value = res
                res.token.logErrorMessage()
            } catch (e: IOException) {
                "Please check your internet connection".logErrorMessage()
            } catch (e: HttpException) {
                "Server error: ${e.code()}".logErrorMessage()
            } catch (e: Exception) {
                "Unexpected error: ${e.localizedMessage}".logErrorMessage()
            }
        }
    }
}