package comit.simsimpulyi.koala.persistence.user

import comit.simsimpulyi.koala.domain.user.model.User
import comit.simsimpulyi.koala.domain.user.spi.QueryUserPort
import comit.simsimpulyi.koala.domain.user.spi.SaveUserPort
import java.util.*

class UserPersistenceAdapter(
    private val repository: UserRepository
) : SaveUserPort, QueryUserPort {

    override fun saveUser(user: User): User {
        TODO("Not yet implemented")
    }

    override fun getUser(userId: UUID): User {
        TODO("Not yet implemented")
    }

}