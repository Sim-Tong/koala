package comit.simsimpulyi.koala.global.security.principle

import comit.simsimpulyi.koala.persistence.user.UserPersistenceAdapter
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.util.*

@Component
class AuthDetailsService(
    private val userPersistenceAdapter: UserPersistenceAdapter
) : UserDetailsService {

    override fun loadUserByUsername(userId: String): UserDetails {
        val id = UUID.fromString(userId)

        val user = userPersistenceAdapter.findUserEntityById(id)?:throw Exception() // TODO
        return AuthDetails(id, user.authority)
    }

}