package comit.simsimpulyi.koala.domain.user.spi

import comit.simsimpulyi.koala.domain.user.model.User

interface SaveUserPort {

    fun saveUser(user: User): User

    fun saveUserEncryption(user: User): User

}