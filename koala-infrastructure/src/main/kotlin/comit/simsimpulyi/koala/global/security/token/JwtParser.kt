package comit.simsimpulyi.koala.global.security.token

import comit.simsimpulyi.koala.global.security.SecurityProperties
import comit.simsimpulyi.koala.global.security.principle.AuthDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Header
import io.jsonwebtoken.InvalidClaimException
import io.jsonwebtoken.Jws
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureException
import io.jsonwebtoken.UnsupportedJwtException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest

@Component
class JwtParser(
    private val securityProperties: SecurityProperties,
    private val authDetailsService: AuthDetailsService
) {

    fun resolveToken(request: HttpServletRequest): String? {
        val bearer = request.getHeader(JwtComponent.JWT_HEADER)
        if(bearer.isNotEmpty().and(bearer.startsWith(JwtComponent.JWT_PREFIX))) {
            return bearer.substring(7)
        }
        return null
    }

    private fun getClaims(token: String): Jws<Claims> {
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
    }

    fun getAuthentication(token: String) : Authentication {
        val claims = getClaims(token)

        if(claims.header[Header.JWT_TYPE] != JwtComponent.ACCESS) throw Exception() // TODO

        val detail = authDetailsService.loadUserByUsername(claims.body.subject)

        return UsernamePasswordAuthenticationToken(detail, "", detail.authorities)
    }
}