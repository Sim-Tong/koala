package comit.simsimpulyi.koala.persistence.user

import comit.simsimpulyi.koala.domain.user.model.User
import comit.simsimpulyi.koala.domain.user.spi.UserPersistencePort
import comit.simsimpulyi.koala.global.annotation.Adapter
import java.util.*

@Adapter
class UserPersistenceAdapter(
    private val repository: UserRepository
) : UserPersistencePort {

    override fun saveUser(user: User): User {
        TODO("Not yet implemented")
    }

    override fun getUser(userId: UUID): User {
        TODO("Not yet implemented")
    }

}