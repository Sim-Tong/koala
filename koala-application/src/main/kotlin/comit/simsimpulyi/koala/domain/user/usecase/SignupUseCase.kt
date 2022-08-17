package comit.simsimpulyi.koala.domain.user.usecase

import comit.simsimpulyi.koala.domain.user.model.User
import comit.simsimpulyi.koala.domain.user.spi.QueryUserPort
import comit.simsimpulyi.koala.domain.user.spi.SaveUserPort
import org.springframework.stereotype.Service

@Service
class SignupUseCase(
    private val queryUserPort: QueryUserPort,
    private val saveUserPort: SaveUserPort,
) {

    fun execute(user: User) {
        if(queryUserPort.existUserByEmail(user.email)) {
            throw Exception() // TODO
        }

        saveUserPort.saveUser(user);
    }
}