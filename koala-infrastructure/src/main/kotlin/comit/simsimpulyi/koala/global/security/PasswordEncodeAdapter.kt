package comit.simsimpulyi.koala.global.security

import comit.simsimpulyi.koala.domain.user.model.User
import comit.simsimpulyi.koala.domain.user.spi.PasswordEncodePort
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class PasswordEncodeAdapter(
    private val passwordEncoder: PasswordEncoder
) : PasswordEncodePort {

    override fun compare(targetPassword: String, encryptedPassword: String): Boolean {
        return passwordEncoder.matches(targetPassword, encryptedPassword)
    }

    override fun encode(user: User): User {
        return user.updatePassword(passwordEncoder.encode(user.password))
    }

}