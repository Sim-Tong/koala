package comit.simsimpulyi.koala.user.dto.request

data class WebSignupRequest(
    val name: String,
    val email: String,
    val password: String,
)