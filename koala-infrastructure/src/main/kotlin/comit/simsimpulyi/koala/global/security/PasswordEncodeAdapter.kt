package comit.simsimpulyi.koala.global.security

import comit.simsimpulyi.koala.domain.user.spi.PasswordEncodePort
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class PasswordEncodeAdapter(
    private val passwordEncoder: PasswordEncoder
) : PasswordEncodePort {

    override fun matchPassword(target: String, encrypted: String): Boolean {
        return passwordEncoder.matches(target, encrypted)
    }

    override fun passwordEncryption(password: String): String {
        return passwordEncoder.encode(password)
    }

}