package comit.simsimpulyi.koala.domain.user.usecase

import comit.simsimpulyi.koala.domain.user.model.User
import comit.simsimpulyi.koala.domain.user.spi.QueryUserPort
import comit.simsimpulyi.koala.domain.user.spi.SaveUserPort
import comit.simsimpulyi.koala.domain.user.usecase.dto.DomainSignupRequest
import comit.simsimpulyi.koala.global.annotation.ApplicationService

@ApplicationService
class SignupUseCase(
    private val queryUserPort: QueryUserPort,
    private val saveUserPort: SaveUserPort
) {

    fun execute(request: DomainSignupRequest) {
        if(queryUserPort.existUserByEmail(request.email)) {
            throw Exception() // TODO
        }

        saveUserPort.saveUser(
            User.createUser(
                email = request.email,
                password = request.password,
                name = request.name,
                authority = request.authority
            )
        )
    }
}