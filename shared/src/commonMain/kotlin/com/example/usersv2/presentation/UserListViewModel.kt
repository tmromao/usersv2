package com.example.usersv2.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.usersv2.domain.User
import com.example.usersv2.domain.UserDataSource
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class UserListViewModel(
    private val userDataSource: UserDataSource,
) : ViewModel() {

    /*    private val _state = MutableStateFlow(
            UserListState(
                users = contacts
            )
        )*/

    //val state = _state.asStateFlow()

    private val _state = MutableStateFlow(UserListState())

    val state = combine(
        _state,
        userDataSource.getUsers()
    ) { state, users ->
        state.copy(users = users)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), UserListState())

    var newUser: User? by mutableStateOf(null)
        private set

    init{
        viewModelScope.launch {
            userDataSource.insertUser(
                User(
                    id = 1,
                    name = "User 1",
                    email = "")
            )

        }
    }

    fun onEvent(event: UserListEvent) {

    }
}

/*
private val contacts = (1..50).map {
    User(
        id = it.toLong(),
        name = "User $it",
        email = "test@teste.pt"
    )
}*/
