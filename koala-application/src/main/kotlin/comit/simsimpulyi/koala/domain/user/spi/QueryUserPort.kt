package comit.simsimpulyi.koala.domain.user.spi

import comit.simsimpulyi.koala.domain.user.model.User
import java.util.*

interface QueryUserPort {

    fun queryUser(userId: UUID): User

    fun queryUser(email: String): User

    fun existUserByEmail(email: String): Boolean

}