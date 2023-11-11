package com.example.usersv2.presentation

import com.example.usersv2.domain.User

sealed interface UserListEvent {
    object OnLoadUsers : UserListEvent
    data class OnUserSelected(val user: User) : UserListEvent
    object OnDeleteUser : UserListEvent
}