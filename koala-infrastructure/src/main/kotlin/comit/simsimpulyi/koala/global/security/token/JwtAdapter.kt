package comit.simsimpulyi.koala.global.security.token

import comit.simsimpulyi.koala.domain.user.model.Authority
import comit.simsimpulyi.koala.domain.user.spi.ReceiveTokenPort
import comit.simsimpulyi.koala.global.security.SecurityProperties
import comit.simsimpulyi.koala.global.security.principle.AuthDetailsService
import io.jsonwebtoken.*
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class JwtAdapter(
    private val securityProperties: SecurityProperties,
    private val authDetailsService: AuthDetailsService
) : ReceiveTokenPort {

    override fun generateAccessToken(userId: UUID, authority: Authority): String {
        return generateToken(userId, authority, securityProperties.accessExpire, "access")
    }

    override fun generateRefreshToken(userId: UUID, authority: Authority): String {
        return generateToken(userId, authority, securityProperties.refreshExpire, "refresh")
    }

    fun generateToken(userId: UUID, authority: Authority, exp: Int, type: String): String {
        return Jwts.builder()
            .signWith(SignatureAlgorithm.HS512, securityProperties.secret)
            .setHeaderParam(Header.JWT_TYPE, type)
            .setSubject(userId.toString())
            .claim("authority", authority)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + exp))
            .compact()
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearer = request.getHeader("Authentication")
        if(bearer.isNotEmpty().and(bearer.startsWith("bearer "))) {
            return bearer.substring(7)
        }
        return null
    }

    fun getClaims(token: String): Jws<Claims> {
        return Jwts.parser()
            .setSigningKey(securityProperties.secret)
            .parseClaimsJws(token)
    }

    fun getAuthentication(token: String) : Authentication {
        val claims = getClaims(token).body
        claims[Header.JWT_TYPE] ?: throw Exception() // TODO

        val detail = authDetailsService.loadUserByUsername(claims.subject)
        return UsernamePasswordAuthenticationToken(detail, "", detail.authorities)
    }
}