package comit.simsimpulyi.koala.domain.user.service

import comit.simsimpulyi.koala.domain.user.model.User
import comit.simsimpulyi.koala.global.annotation.Port
import java.util.*

@Port
interface UserPersistencePort {

    fun save(user: User): User

    fun getUser(userId: UUID): User
}