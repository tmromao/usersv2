package com.example.usersv2

import androidx.compose.ui.window.ComposeUIViewController
import com.example.usersv2.di.AppModule

fun MainViewController() = ComposeUIViewController {

    App(
        darkTheme = false,
        dynamicColor = false,
        appModule = AppModule()
    )
}