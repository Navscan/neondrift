plugins {
    id("com.android.application")
}

android {
    namespace = "com.flipstack.neondrift"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.flipstack.neondrift"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    signingConfigs {
        create("release") {
            storeFile = file("../neondrift-release.jks")
            storePassword = System.getenv("KEYSTORE_PASSWORD") ?: "password123"
            keyAlias = "neondrift"
            keyPassword = System.getenv("KEYSTORE_PASSWORD") ?: "password123"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
}
