package com.example.usersv2.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.usersv2.domain.User
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class UserListViewModel : ViewModel() {

    private val _state = MutableStateFlow(UserListState(
        users = contacts
    ))
    val state = _state.asStateFlow()

    var newUser: User? by mutableStateOf(null)
        private set

    fun onEvent(event: UserListEvent){

    }
}

private val contacts = (1..50).map {
    User(
        id = it.toLong(),
        name = "User $it",
        email = "test@teste.pt"
    )
}