plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.metricv2"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.metricv2"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf(
                    "room.schemaLocation" to "$projectDir/schemas",
                    "room.incremental" to "true"
                )
            }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    val navVersion = "2.5.3"

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Navigation Component
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    // Handle different screen size
    implementation("com.intuit.sdp:sdp-android:1.1.0")

    // Handle different screen and text size
    implementation("com.intuit.ssp:ssp-android:1.1.0")

    // Loading Animation
    implementation ("pl.droidsonroids.gif:android-gif-drawable:1.2.28")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    // JSON to Kotlin Object Converter
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Put image from Internet to ImageView
    implementation("com.github.bumptech.glide:glide:4.16.0")

    // ViewModel Dependencies
    val lifecycleVersion = "2.5.1"

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycleVersion")

    // Library untuk Observer ViewModel
    implementation("androidx.lifecycle:lifecycle-extensions:2.1.0")

    val roomVersion = "2.6.1"

    implementation("androidx.room:room-runtime:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")

    //

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0-RC")
}
