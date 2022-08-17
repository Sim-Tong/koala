package comit.simsimpulyi.koala.domain.user.spi

import comit.simsimpulyi.koala.domain.user.model.User

interface PasswordEncodePort {

    fun compare(targetPassword: String, encryptedPassword: String): Boolean

    fun encode(user: User): User

}