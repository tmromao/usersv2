import com.example.usersv2.domain.User
import database.UserEntity

fun UserEntity.toUser(): User {
    return User(
        id = id,
        name = name,
        email = email
    )
}