package comit.simsimpulyi.koala.global.security

import comit.simsimpulyi.koala.domain.user.spi.SecurityPort
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class SecurityAdapter(
    private val passwordEncoder: PasswordEncoder
) : SecurityPort {

    override fun compare(targetPassword: String, encryptedPassword: String): Boolean {
        return passwordEncoder.matches(targetPassword, encryptedPassword)
    }

    override fun encode(password: String): String {
        return passwordEncoder.encode(password)
    }

}