import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    //alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.sqldelight)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
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
        val commonMain by getting {

            //put your multiplatform dependencies here
            dependencies {
                implementation(libs.bundles.compose.multiplatform)

                implementation(libs.sqldelight.coroutines)
                implementation(libs.koin.core)
                implementation(libs.koin.compose)

                api(libs.bundles.moko.mvvm)
            }

        }
        val commonTest by getting {
            dependencies{
                implementation(libs.kotlin.test)
            }
        }
        val androidMain by getting {
            //put your android dependencies here
            dependencies{
                implementation(libs.androidx.core.ktx)
                implementation(libs.sqldelight.driver.android)
            }

        }
        val iosMain by creating {
            //put your ios dependencies here
            dependencies {
                implementation(libs.sqldelight.driver.native)
            }
        }
    }
}

android {
    namespace = "com.example.usersv2"
    compileSdk = 34
    defaultConfig {
        minSdk = 29
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
