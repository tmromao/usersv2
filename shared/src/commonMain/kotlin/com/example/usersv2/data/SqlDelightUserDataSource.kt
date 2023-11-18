package com.example.usersv2.data

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.example.usersv2.database.UsersDatabase
import com.example.usersv2.domain.User
import com.example.usersv2.domain.UserDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import toUser

class SqlDelightUserDataSource(
    db: UsersDatabase,
) : UserDataSource {

    private val queries = db.userQueries
    override fun getUsers(): Flow<List<User>> {
        return queries
            .getUsers()
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map { userEntityList ->
                userEntityList.map { userEntity ->
                    userEntity.toUser()
                }
            }
    }

    override suspend fun insertUser(user: User) {
        queries.insertUserEntity(
            id = user.id,
            name = user.name,
            email = user.email
        )
    }

    override suspend fun deleteUser(id: Long) {
        queries.deleteUserEntity(id)
    }
}