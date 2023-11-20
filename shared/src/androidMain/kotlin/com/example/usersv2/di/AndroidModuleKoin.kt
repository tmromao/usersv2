package com.example.usersv2.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.usersv2.database.UsersDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single<SqlDriver> {
        AndroidSqliteDriver(
            schema = UsersDatabase.Schema,
            context = androidContext(),
            name = "users.db"
        )
    }
}