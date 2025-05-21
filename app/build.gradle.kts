import org.gradle.api.internal.properties.GradleProperties
import org.gradle.buildinit.plugins.internal.GradlePropertiesGenerator
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.devtools.ksp")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

val localProperties = Properties().apply {
    val localPropertiesFile = rootProject.file("local.properties")

    if (localPropertiesFile.exists()) {
        localPropertiesFile.inputStream().use { load(it) }
    }
}

android {
    namespace = "com.cst.cstacademy2025unibucif"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.cst.cstacademy2025unibucif"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "5.4.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        buildConfig = true
        dataBinding = true
    }
}

android {
    flavorDimensions += listOf("environment")

    productFlavors {
        create("dev") {
            dimension = "environment"
            applicationIdSuffix = ".dev"
            manifestPlaceholders["appName"] = "Dev App"

            val devBaseUrl = project.properties["dev_base_url"] ?: "http://localhost:8080/"
            buildConfigField("String", "ENVIRONMENT", devBaseUrl.toString())

            val devReqresApiKey = localProperties.getProperty("dev_reqres_api_key") ?: "default"
            buildConfigField("String", "REQRES_API_KEY", "\"$devReqresApiKey\"")
        }

        create("prod") {
            dimension = "environment"
            manifestPlaceholders["appName"] = "Prod App"

            val prodBaseUrl = project.properties["prod_base_url"] ?: "http://localhost:8080/"
            buildConfigField("String", "ENVIRONMENT", prodBaseUrl.toString())

            val prodReqresApiKey = localProperties.getProperty("prod_reqres_api_key") ?: "default"
            buildConfigField("String", "REQRES_API_KEY", "\"$prodReqresApiKey\"")
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Jetpack Compose integration
    implementation(libs.androidx.navigation.compose)
    // Views/Fragments integration
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    // Feature module support for Fragments
    implementation(libs.androidx.navigation.dynamic.features.fragment)
    // Testing Navigation
    androidTestImplementation(libs.androidx.navigation.testing)
    // JSON serialization library, works with the Kotlin serialization plugin
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.androidx.room.runtime)
    // If this project uses any Kotlin source, use Kotlin Symbol Processing (KSP)
    // See Add the KSP plugin to your project
    ksp(libs.androidx.room.compiler)
    // If this project only uses Java source, use the Java annotationProcessor
    // No additional plugins are necessary
    annotationProcessor(libs.androidx.room.compiler)
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation(libs.androidx.room.ktx)

    implementation(libs.retrofit)
    implementation(libs.converter.gson) // For JSON parsing
    implementation(libs.logging.interceptor) // Logging
    implementation(libs.kotlinx.coroutines.android) // Coroutines

    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
    implementation(libs.glide)

    implementation(libs.androidx.core.splashscreen)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}