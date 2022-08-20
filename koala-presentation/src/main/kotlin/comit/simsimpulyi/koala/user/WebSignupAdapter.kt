package comit.simsimpulyi.koala.user

import comit.simsimpulyi.koala.domain.user.model.Authority
import comit.simsimpulyi.koala.domain.user.usecase.SignupUseCase
import comit.simsimpulyi.koala.domain.user.usecase.dto.DomainSignupRequest
import comit.simsimpulyi.koala.user.dto.request.WebSignupRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class WebSignupAdapter(
    private val signupUseCase: SignupUseCase
) {

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    fun signUp(request: WebSignupRequest) {
        signupUseCase.execute(DomainSignupRequest(
            email = request.email,
            name = request.name,
            password = request.password,
            authority = Authority.ROLE_USER
        ))

        // login token
    }
}