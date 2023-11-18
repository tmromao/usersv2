package com.example.usersv2.domain

import kotlinx.coroutines.flow.Flow

interface UserDataSource {
    fun getUsers(): Flow<List<User>>
   // fun getUserById(id: Int): Flow<User>

    suspend fun insertUser(user: User)
    suspend fun deleteUser(id: Long)

}