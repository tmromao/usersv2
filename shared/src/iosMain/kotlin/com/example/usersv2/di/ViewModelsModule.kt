package com.example.usersv2.di

import com.example.usersv2.presentation.UserListViewModel
import org.koin.dsl.module

actual fun getViewModelByPlatform() = module {
    single {
        UserListViewModel(get())
    }
}

