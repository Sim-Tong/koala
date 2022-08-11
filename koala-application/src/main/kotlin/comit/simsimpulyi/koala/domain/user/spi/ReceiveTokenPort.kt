package comit.simsimpulyi.koala.domain.user.spi

import comit.simsimpulyi.koala.domain.user.model.Authority
import java.util.*

interface ReceiveTokenPort {

    fun generateAccessToken(userId: UUID, authority: Authority): String

    fun generateRefreshToken(userId: UUID, authority: Authority): String
}