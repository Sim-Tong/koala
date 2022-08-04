package comit.simsimpulyi.koala.domain.user.spi

import comit.simsimpulyi.koala.domain.user.model.User
import comit.simsimpulyi.koala.global.annotation.Port
import java.util.*

@Port
interface UserPersistencePort {

    fun saveUser(user: User): User

    fun getUser(userId: UUID): User
}