package comit.simsimpulyi.koala.domain.user.usecase.dto

import comit.simsimpulyi.koala.domain.user.model.Authority

class DomainSignupRequest(
    val email: String,
    val password: String,
    val name: String,
    val authority: Authority
)