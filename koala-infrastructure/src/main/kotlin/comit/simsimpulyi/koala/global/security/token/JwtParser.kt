package comit.simsimpulyi.koala.global.security.token

import comit.simsimpulyi.koala.global.security.SecurityProperties
import comit.simsimpulyi.koala.global.security.principle.AuthDetailsService
import io.jsonwebtoken.*
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class JwtParser(
    private val securityProperties: SecurityProperties,
    private val authDetailsService: AuthDetailsService
) {

    private fun getClaims(token: String): Jws<Claims>? {
        try {
            return Jwts.parser()
                .setSigningKey(securityProperties.secretKey)
                .parseClaimsJws(token)
        } catch (e: InvalidClaimException) {
            // TODO
        } catch (e: ExpiredJwtException) {
            // TODO
        } catch (e: SignatureException) {
            // TODO
        } catch (e: UnsupportedJwtException) {
            // TODO
        } catch (e: RuntimeException) {
            // TODO
        }
        return null
    }

    fun getAuthentication(token: String) : Authentication? {
        val claims = getClaims(token)
        
        claims?.let {
            if(claims.header[Header.JWT_TYPE] != JwtComponent.ACCESS) throw Exception() // TODO

            val detail = authDetailsService.loadUserByUsername(claims.body.subject)

            return UsernamePasswordAuthenticationToken(detail, "", detail.authorities)
        }

        return null
    }
}