package comit.simsimpulyi.koala.domain.user.spi

import comit.simsimpulyi.koala.domain.user.model.Authority

interface ReceiveTokenPort {

    fun generateAccessToken(email: String, authority: Authority): String

    fun generateRefreshToken(email: String, authority: Authority): String

}