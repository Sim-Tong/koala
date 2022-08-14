package comit.simsimpulyi.koala.global.security.principle

import comit.simsimpulyi.koala.persistence.user.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.util.*

@Component
class AuthDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(userId: String): UserDetails {
        val id = UUID.fromString(userId)

        val user = userRepository.queryUserEntityById(id)?:throw Exception() // TODO
        return AuthDetails(id, user.authority)
    }

}