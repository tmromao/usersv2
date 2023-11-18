import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.usersv2.domain.UserListItem
import com.example.usersv2.presentation.UserListEvent
import com.example.usersv2.presentation.UserListState


@Composable
fun UserListScreen(
    state: State<UserListState>,
    onEvent: (UserListEvent) -> Unit,
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

       items(state.value.users) { user ->
            UserListItem(
                user = user,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        //onEvent(UserListEvent.OnUserSelected(user))
                    }
                    .padding(16.dp)
            )
        }
    }

}