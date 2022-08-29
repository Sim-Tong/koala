package comit.simsimpulyi.koala.user.dto.request

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class WebSignupRequest(

    @field:NotNull
    @field:Length(max = 20)
    val name: String,

    @field:Email
    val email: String,

    @field:NotBlank
    val password: String,
)