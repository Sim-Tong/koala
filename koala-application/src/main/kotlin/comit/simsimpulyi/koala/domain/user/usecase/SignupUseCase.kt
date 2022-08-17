package comit.simsimpulyi.koala.domain.user.usecase

import comit.simsimpulyi.koala.domain.user.model.User
import comit.simsimpulyi.koala.domain.user.spi.QueryUserPort
import comit.simsimpulyi.koala.domain.user.spi.SaveUserPort
import comit.simsimpulyi.koala.domain.user.spi.SecurityPort
import comit.simsimpulyi.koala.domain.user.usecase.dto.DomainSignupRequest
import comit.simsimpulyi.koala.global.annotation.ApplicationService

@ApplicationService
class SignupUseCase(
    private val queryUserPort: QueryUserPort,
    private val saveUserPort: SaveUserPort,
    private val securityPort: SecurityPort
) {

    fun execute(request: DomainSignupRequest) {
        if(queryUserPort.existUserByEmail(request.email)) {
            throw Exception() // TODO
        }

        saveUserPort.saveUser(
            User(
                email = request.email,
                authority = request.authority,
                name = request.name,
                password = securityPort.encode(request.password),
                id = null
            )
        )
    }
}