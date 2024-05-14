plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.piterrus.dagger2"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.piterrus.dagger2"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }
    kotlin {
        jvmToolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    //ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    //Compose
    implementation(libs.compose.ui)
    implementation(libs.compose.graphics)
    implementation(libs.compose.preview)
    implementation(libs.androidx.camera.lifecycle)
    testImplementation(libs.androidx.junit.ktx)
    testImplementation(libs.androidx.runner)
    debugImplementation(libs.compose.tooling)
    debugImplementation(libs.compose.test.manifest)
    androidTestImplementation(libs.compose.test.junit4)
    androidTestImplementation(platform(libs.compose.bom))
    //ComposeActivity
    implementation(libs.compose.activity)
    //Core Ktx
    implementation(libs.core.ktx)
    //Immutable Collections
    implementation(libs.immutable.collections)
    //Material 3
    implementation(libs.material3)
    //JUnit4 + Espresso
    testImplementation(libs.junit)
    androidTestImplementation(libs.junit.extensions)
    androidTestImplementation(libs.espresso.core)
    //Dagger 2
    implementation(libs.dagger.core)
    kapt(libs.dagger.compiler)
    implementation(kotlin("reflect"))
    //Mockk
    testImplementation(libs.mockk)
    testImplementation(libs.androidx.core.testing)
    //Testing
    testImplementation(libs.room.testing)
    testImplementation(libs.robolectric)
    implementation(libs.kotlinx.coroutines.test)
    //Multidex
    implementation(libs.support.multidex)
}