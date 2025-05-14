package com.cst.cstacademy2025unibucif.ui

import android.os.Bundle
import androidx.core.splashscreen.SplashScreen
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import com.cst.cstacademy2025unibucif.R
import com.cst.cstacademy2025unibucif.databinding.ActivityControllerBinding
import com.cst.cstacademy2025unibucif.managers.SharedPreferencesManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class ControllerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityControllerBinding
    private lateinit var splashScreen: SplashScreen
    private var isAppInit: Boolean = false
    private val navController by lazy {
        val host = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment)
                as? NavHostFragment
            ?: error("NavHostFragment not found in layout")
        host.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setupSplashScreen()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_controller)
        binding.lifecycleOwner = this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        handleUserStatus()
    }

    private fun setupHomeNavigation() {
        navController.setGraph(R.navigation.home_navigation)
    }

    // ToDo: Improve
    private fun setupAuthenticationNavigation() {
        navController.setGraph(R.navigation.authentication_navigation)
    }

    private fun checkAuthToken(): Boolean {
        return !SharedPreferencesManager.getAuthToken().isNullOrEmpty()
    }

    private fun handleUserStatus() {
        lifecycleScope.launch {
            val isTokenPresent = withContext(Dispatchers.IO) {
                delay(3000)

                checkAuthToken()
            }

            when (isTokenPresent) {
                true -> setupHomeNavigation()
                false -> setupAuthenticationNavigation()
            }

            isAppInit = true
        }
    }

    private fun setupSplashScreen() {
        splashScreen = installSplashScreen().apply {
            this.setKeepOnScreenCondition {
                !isAppInit
            }

            this.setOnExitAnimationListener {
                it.remove()
            }
        }
    }
}