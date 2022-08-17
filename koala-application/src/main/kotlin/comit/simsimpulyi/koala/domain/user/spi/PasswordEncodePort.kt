package comit.simsimpulyi.koala.domain.user.spi

interface PasswordEncodePort {

    fun matchPassword(target: String, encrypted: String): Boolean

    fun passwordEncryption(password: String): String

}