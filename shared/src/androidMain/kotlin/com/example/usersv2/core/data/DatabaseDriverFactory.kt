package com.example.usersv2.core.data

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.usersv2.database.UsersDatabase

actual class DatabaseDriverFactory(
    private val context: Context,
) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = UsersDatabase.Schema,
            context = context,
            name = "users.db"
        )
    }
}