package com.example.usersv2.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.usersv2.ui.theme.DarkColorScheme
import com.example.usersv2.ui.theme.LightColorScheme
import com.example.usersv2.ui.theme.Typography

@Composable
actual fun UsersTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = Typography,
        content = content
    )
}