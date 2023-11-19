package com.example.usersv2.presentation

import com.example.usersv2.domain.User

data class UserListState(
    val users: List<User> = emptyList(),

)