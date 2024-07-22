plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.computer_calc"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.computer_calc"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.sessions)
    androidTestImplementation(libs.ext.junit)
    testImplementation(libs.junit.v412)
    testImplementation(libs.mockito.core)
    //
    androidTestImplementation("com.android.support:support-annotations:24.0.0")
    androidTestImplementation("com.android.support.test:runner:0.5")
    androidTestImplementation("com.android.support.test:rules:0.5")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:2.2.2")
}