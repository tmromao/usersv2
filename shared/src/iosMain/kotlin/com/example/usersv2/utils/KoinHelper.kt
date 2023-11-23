package com.example.usersv2.utils

import com.example.usersv2.di.getSharedModules
import com.example.usersv2.presentation.UserListViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin

fun initKoin()  {
    startKoin {
        modules(
            getSharedModules()
        )
    }
}

class KoinHelper:KoinComponent{
    fun getAppViewModel() = get<UserListViewModel>()
}