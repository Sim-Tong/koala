package comit.simsimpulyi.koala.domain.user.model

import comit.simsimpulyi.koala.domain.user.spi.SecurityPort
import comit.simsimpulyi.koala.global.annotation.Aggregate
import java.util.*

@Aggregate
class User(
    val id: UUID?,

    val name: String,

    val password: String,

    val email: String,

    val authority: Authority
) {

    fun updateNameAndEmail(name: String, email: String): User {
        return User(
            id = this.id,
            name = name,
            password = this.password,
            email = email,
            authority = this.authority
        )
    }

    companion object {
        fun createUser(name: String, password: String, authority: Authority, email: String): User {
            return User(
                name = name,
                password = SecurityPort::encode.let { password },
                authority = authority,
                email = email,
                id = null
            )
        }
    }

}