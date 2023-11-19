package com.example.usersv2

import UserListScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.usersv2.di.AppModule
import com.example.usersv2.presentation.UserListViewModel
import com.example.usersv2.presentation.UsersTheme
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory

@Composable
fun App(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    appModule: AppModule
) {
    UsersTheme(
        darkTheme = darkTheme,
        dynamicColor = dynamicColor
    ) {
        val viewModel = getViewModel(
            key = "users-list-screen",
            factory = viewModelFactory {
                UserListViewModel(appModule.userDataSource)
            }
        )
        val state = viewModel.state.collectAsState()
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            UserListScreen(
                state = state,
                onEvent = viewModel::onEvent
            )

        }

    }

}