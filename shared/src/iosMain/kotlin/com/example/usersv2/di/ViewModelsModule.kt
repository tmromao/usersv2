package com.example.usersv2.di

import com.example.usersv2.presentation.UserListViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.dsl.module

actual fun getViewModelByPlatform() = module {
    single {
        UserListViewModel(get())
    }
}

object KoinHelper:KoinComponent{
    fun getUserListViewModel() = get<UserListViewModel>()
}