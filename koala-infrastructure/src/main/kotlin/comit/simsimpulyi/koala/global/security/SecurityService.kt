package comit.simsimpulyi.koala.global.security

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class SecurityService(
    private val passwordEncoder: PasswordEncoder
) {

    fun compare(targetPassword: String, encryptedPassword: String): Boolean {
        return passwordEncoder.matches(targetPassword, encryptedPassword)
    }

    fun encode(password: String): String {
        return passwordEncoder.encode(password)
    }

}