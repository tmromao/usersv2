plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.sqldelight)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation(libs.sqldelight.coroutines)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        androidMain.dependencies {
            //put your android dependencies here
            implementation(libs.sqldelight.driver.android)
        }
        iosMain.dependencies {
            //put your ios dependencies here
            implementation(libs.sqldelight.driver.native)
        }
    }
}

android {
    namespace = "com.example.usersv2"
    compileSdk = 34
    defaultConfig {
        minSdk = 29
    }
}
