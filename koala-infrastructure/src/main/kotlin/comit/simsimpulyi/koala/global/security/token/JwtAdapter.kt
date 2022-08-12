package comit.simsimpulyi.koala.global.security.token

import comit.simsimpulyi.koala.domain.user.model.Authority
import comit.simsimpulyi.koala.domain.user.spi.ReceiveTokenPort
import comit.simsimpulyi.koala.global.security.SecurityProperties
import io.jsonwebtoken.Header
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtAdapter(
    private val securityProperties: SecurityProperties
) : ReceiveTokenPort {

    override fun generateAccessToken(email: String, authority: Authority): String {
        return generateToken(email, authority, securityProperties.accessExpire, "access")
    }

    override fun generateRefreshToken(email: String, authority: Authority): String {
        return generateToken(email, authority, securityProperties.refreshExpire, "refresh")
    }

    private fun generateToken(email: String, authority: Authority, exp: Int, type: String): String {
        return Jwts.builder()
            .signWith(SignatureAlgorithm.HS512, securityProperties.secretKey)
            .setHeaderParam(Header.JWT_TYPE, type)
            .setSubject(email)
            .claim("authority", authority)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + exp))
            .compact()
    }
}