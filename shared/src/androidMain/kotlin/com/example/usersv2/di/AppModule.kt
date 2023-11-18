package com.example.usersv2.di

import android.content.Context
import com.example.usersv2.core.data.DatabaseDriverFactory
import com.example.usersv2.data.SqlDelightUserDataSource
import com.example.usersv2.database.UsersDatabase
import com.example.usersv2.domain.UserDataSource

actual class AppModule(
    private val context: Context
) {

    actual val userDataSource: UserDataSource by lazy {
        SqlDelightUserDataSource(
            db = UsersDatabase(
                driver = DatabaseDriverFactory(context).createDriver()
            )
        )
    }
}