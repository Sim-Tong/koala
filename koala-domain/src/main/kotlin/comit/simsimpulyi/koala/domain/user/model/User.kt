package comit.simsimpulyi.koala.domain.user.model

import comit.simsimpulyi.koala.global.annotation.Aggregate
import java.util.*

@Aggregate
class User(
    val id: UUID,

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
            authority = authority
        )
    }
}