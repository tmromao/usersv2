package com.example.usersv2.presentation

import androidx.compose.runtime.Composable

@Composable
expect fun UsersTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit,
)