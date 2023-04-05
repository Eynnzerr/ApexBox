import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    kotlin("kapt")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.eynnzerr.apexbox"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.eynnzerr.apexbox"
        minSdk = 26
        targetSdk = 33
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
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

// Dependency versions
val coreKtxVersion = "1.9.0"
val lifecycleVersion = "2.5.1"
val junitVersion = "4.13.2"
val junitExtVersion = "1.1.3"
val espressoVersion = "3.4.0"

val composeVersion = "1.3.0-rc01"
val material3Version = "1.0.0-rc01"
val activityVersion = "1.6.0"
val accompanistVersion = "0.28.0"
val leakCanaryVersion = "2.9.1"
val exoPlayerVersion = "2.18.2"
val navigationComposeVersion = "2.5.3"
val hiltNavigationVersion = "1.0.0"
val hiltVersion = "2.44"
val roomVersion = "2.5.0"
val retrofitVersion = "2.9.0"
val MMKVVersion = "1.2.13"
val materialVersion = "1.7.0-alpha02"
val coilVersion = "2.3.0"
val workVersion = "2.8.0"
val hiltWorkVersion = "1.0.0"

dependencies {
    implementation("androidx.hilt:hilt-work:$hiltWorkVersion")
    implementation("androidx.work:work-runtime-ktx:$workVersion")
    implementation("io.coil-kt:coil-compose:$coilVersion")
    implementation("com.google.android.material:material:$materialVersion")
    implementation("com.tencent:mmkv:$MMKVVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    implementation("androidx.hilt:hilt-navigation-compose:$hiltNavigationVersion")
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    implementation("androidx.navigation:navigation-compose:$navigationComposeVersion")
    implementation("com.google.accompanist:accompanist-navigation-animation:$accompanistVersion")
    implementation("com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion")
    // implementation("com.google.android.exoplayer:exoplayer:$exoPlayerVersion")
    implementation("androidx.core:core-ktx:$coreKtxVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    implementation("androidx.activity:activity-compose:$activityVersion")
    implementation("androidx.compose.ui:ui-util:$composeVersion")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")
    implementation("androidx.compose.material3:material3:$material3Version")

    testImplementation("junit:junit:$junitVersion")

    androidTestImplementation("androidx.test.ext:junit:$junitExtVersion")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoVersion")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")

    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")
    debugImplementation("com.squareup.leakcanary:leakcanary-android:$leakCanaryVersion")

    kapt("androidx.hilt:hilt-compiler:$hiltWorkVersion")
    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
}

kapt {
    correctErrorTypes = true
}