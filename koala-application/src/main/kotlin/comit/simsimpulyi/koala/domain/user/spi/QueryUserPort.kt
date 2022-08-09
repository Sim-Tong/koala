package comit.simsimpulyi.koala.domain.user.spi

import comit.simsimpulyi.koala.domain.user.model.User
import java.util.*

interface QueryUserPort {

    fun queryUserById(userId: UUID): User

}