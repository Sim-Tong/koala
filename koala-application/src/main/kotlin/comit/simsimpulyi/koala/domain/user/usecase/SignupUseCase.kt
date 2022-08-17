package comit.simsimpulyi.koala.domain.user.usecase

import comit.simsimpulyi.koala.domain.user.model.User
import comit.simsimpulyi.koala.domain.user.spi.PasswordEncodePort
import comit.simsimpulyi.koala.domain.user.spi.QueryUserPort
import comit.simsimpulyi.koala.domain.user.spi.SaveUserPort
import comit.simsimpulyi.koala.global.annotation.ApplicationService

@ApplicationService
class SignupUseCase(
    private val queryUserPort: QueryUserPort,
    private val saveUserPort: SaveUserPort,
    private val passwordEncodePort: PasswordEncodePort
) {

    fun execute(user: User) {
        if(queryUserPort.existUserByEmail(user.email)) {
            throw Exception() // TODO
        }

        saveUserPort.saveUser(
            passwordEncodePort.encode(user)
        )
    }
}