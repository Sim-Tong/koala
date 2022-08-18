package comit.simsimpulyi.koala.domain.user.spi

interface SecurityPort {

    fun compare(targetPassword: String, encryptedPassword: String): Boolean

    fun encode(password: String): String

}