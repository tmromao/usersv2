package com.example.usersv2.di

import com.example.usersv2.domain.UserDataSource

expect class AppModule {
    val userDataSource: UserDataSource
}