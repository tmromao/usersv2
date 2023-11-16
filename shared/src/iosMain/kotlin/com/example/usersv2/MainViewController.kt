package com.example.usersv2

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {

    App(
        darkTheme = false,
        dynamicColor = false
    )
}