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
class GenerateJwtAdapter(
    private val securityProperties: SecurityProperties
) : ReceiveTokenPort {

    override fun generateAccessToken(email: String, authority: Authority): String {
        return Jwts.builder()
            .signWith(SignatureAlgorithm.HS512, securityProperties.secretKey)
            .setHeaderParam(Header.JWT_TYPE, JwtComponent.ACCESS)
            .setSubject(email)
            .claim(JwtComponent.JWT_AUTHORITY, authority)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + securityProperties.accessExpire))
            .compact()
    }

    override fun generateRefreshToken(email: String, authority: Authority): String {
        return Jwts.builder()
            .signWith(SignatureAlgorithm.HS512, securityProperties.secretKey)
            .setHeaderParam(Header.JWT_TYPE, JwtComponent.REFRESH)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + securityProperties.refreshExpire))
            .compact()
    }
}