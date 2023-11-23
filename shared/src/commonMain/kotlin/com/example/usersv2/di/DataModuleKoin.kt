package com.example.usersv2.di

import com.example.usersv2.data.SqlDelightUserDataSource
import com.example.usersv2.database.UsersDatabase
import com.example.usersv2.domain.UserDataSource
import org.koin.dsl.module

val dataModule = module {
    single<UserDataSource> {
        SqlDelightUserDataSource(
            db = UsersDatabase(driver = get())

        )
    }
}