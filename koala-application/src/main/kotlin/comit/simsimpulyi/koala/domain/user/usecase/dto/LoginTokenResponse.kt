package comit.simsimpulyi.koala.domain.user.usecase.dto

data class LoginTokenResponse(
    val accessToken: String,
    val refreshToken: String
)