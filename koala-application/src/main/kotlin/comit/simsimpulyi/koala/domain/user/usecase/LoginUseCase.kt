package comit.simsimpulyi.koala.domain.user.usecase

import comit.simsimpulyi.koala.domain.user.spi.QueryUserPort
import comit.simsimpulyi.koala.domain.user.spi.ReceiveTokenPort
import comit.simsimpulyi.koala.domain.user.spi.SecurityPort
import comit.simsimpulyi.koala.domain.user.usecase.dto.DomainLoginRequest
import comit.simsimpulyi.koala.domain.user.usecase.dto.LoginTokenResponse
import comit.simsimpulyi.koala.global.annotation.ApplicationService

@ApplicationService
class LoginUseCase(
    private val receiveTokenPort: ReceiveTokenPort,
    private val securityPort: SecurityPort,
    private val queryUserPort: QueryUserPort
) {

    fun execute(request: DomainLoginRequest): LoginTokenResponse {
        val user = queryUserPort.queryUserByEmail(request.email);

        if(securityPort.compare(request.password, user.password)) {
            throw Exception() // TODO
        }

        return LoginTokenResponse(
            accessToken = receiveTokenPort.generateAccessToken(user.email, user.authority),
            refreshToken = receiveTokenPort.generateRefreshToken(user.email, user.authority)
        )
    }
}