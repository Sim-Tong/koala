package comit.simsimpulyi.koala.global.security.token

import comit.simsimpulyi.koala.global.security.SecurityProperties
import comit.simsimpulyi.koala.global.security.principle.AuthDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Header
import io.jsonwebtoken.InvalidClaimException
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureException
import io.jsonwebtoken.UnsupportedJwtException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class JwtParser(
    private val securityProperties: SecurityProperties,
    private val authDetailsService: AuthDetailsService
) {

    private fun getClaims(token: String): Jws<Claims>? {
        return try {
            Jwts.parser()
                .setSigningKey(securityProperties.secretKey)
                .parseClaimsJws(token)
        } catch (e: Exception) {
            when (e) {
                is InvalidClaimException -> throw Exception() // TODO
                is ExpiredJwtException -> throw Exception() // TODO
                is SignatureException -> throw Exception() // TODO
                is UnsupportedJwtException -> throw Exception() // TODO
                else -> null
            }
        }
    }

    fun getAuthentication(token: String): Authentication? {
        val claims = getClaims(token)

        claims?.let {
            if (claims.header[Header.JWT_TYPE] != JwtComponent.ACCESS) {
                throw Exception() // TODO
            }

            val detail = authDetailsService.loadUserByUsername(claims.body.subject)

            return UsernamePasswordAuthenticationToken(detail, "", detail.authorities)
        }

        return null
    }
}