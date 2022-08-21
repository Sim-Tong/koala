package comit.simsimpulyi.koala.domain.user.usecase.dto

data class DomainLoginRequest(
    val email: String,
    val password: String
)