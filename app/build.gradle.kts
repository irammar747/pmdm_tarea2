plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.ramirez_marin_inmaculada_pmdm_02"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ramirez_marin_inmaculada_pmdm_02"
        minSdk = 31
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures{
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation(libs.recyclerview)
    implementation(libs.cardview)
    //implementation(libs.navigation.fragment)
    //implementation(libs.navigation.ui.ktx)

    //implementation("androidx.recyclerview:recyclerview")
    //implementation("androidx.cardview:cardview")
    implementation("androidx.navigation:navigation-fragment-ktx")
    implementation("androidx.navigation:navigation-ui-ktx")

    //Para la splash
    implementation("androidx.core:core-splashscreen:1.0.1")

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.androidx.navigation.fragment)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}