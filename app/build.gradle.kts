plugins {
    id("com.android.application")


    id("org.jetbrains.kotlin.android")

    id ("org.sonarqube") version "3.3"
    id ("jacoco")

}






android {
    namespace = "com.example.firstandroidapp"


    compileSdk = 33



    defaultConfig {
        applicationId = "com.example.firstandroidapp"
        minSdk = 29
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {

        debug {
            // Enable JaCoCo coverage for the debug build
            isTestCoverageEnabled = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}


dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

}

sonarqube {
    properties {
        property("sonar.host.url", "http://localhost:9000") // Change to your SonarQube server URL
        property("sonar.login", "04fae4924d762058decb88a09bc9064fd80f8e5b")     // Replace with your authentication token
        property ("sonar.projectKey", "23753-first-android-app")
        property ("sonar.projectName", "23753-first-android-app")
        property ("sonar.tests", "src/test/java")
        property ("sonar.test.inclusions", "**/*Test*/**"
        )
        property ("sonar.sourceEncoding", "UTF-8")
        property ("sonar.sources", "src/main/java")
    }
}



