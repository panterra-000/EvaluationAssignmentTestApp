plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}


android {
    namespace = "mapp.test.evaluationassignmenttestapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "mapp.test.evaluationassignmenttestapp"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "BASE_URL", "\"http://54.246.238.84:3000/graphql\"")
            buildConfigField("String", "JWT", "\"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlSWQiOjE0MDMsImZJZCI6IkRHcjVYMGZHNDdYQW9LUGkiLCJzSWQiOjQxLCJpYXQiOjE2ODMxNDA5MjcsImV4cCI6MTY4NDM1MDUyN30.oC5ka2mlWWoEIXmM7m_FnXjtEqKDzLTjAIu_fwcrA8Y\"")
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "BASE_URL", "\"http://54.246.238.84:3000/graphql\"")
            buildConfigField("String", "JWT", "\"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlSWQiOjE0MDMsImZJZCI6IkRHcjVYMGZHNDdYQW9LUGkiLCJzSWQiOjQxLCJpYXQiOjE2ODMxNDA5MjcsImV4cCI6MTY4NDM1MDUyN30.oC5ka2mlWWoEIXmM7m_FnXjtEqKDzLTjAIu_fwcrA8Y\"")
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
        kotlinCompilerExtensionVersion = "1.2.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":coreui"))
    implementation(project(":presentation"))

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.3.1")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.2.0")
    debugImplementation("androidx.compose.ui:ui-tooling:1.2.0")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.2.0")

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
    implementation("com.google.dagger:hilt-android:2.42")
    kapt("com.google.dagger:hilt-android-compiler:2.42")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
}