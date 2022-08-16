package comit.simsimpulyi.koala.global.filter

import comit.simsimpulyi.koala.global.security.token.JwtComponent
import comit.simsimpulyi.koala.global.security.token.JwtParser
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtFilter(
    private val jwtParser: JwtParser
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val resolvedToken = resolveToken(request)
        resolvedToken?.let { token ->
            val authentication = jwtParser.getAuthentication(token)

            authentication?.let { auth ->
                SecurityContextHolder.getContext().authentication = auth
            }
        }

        filterChain.doFilter(request, response)
    }

    private fun resolveToken(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader(JwtComponent.JWT_HEADER)

        if (bearerToken.isNotEmpty().and(bearerToken.startsWith(JwtComponent.JWT_PREFIX))) {
            return bearerToken.substring(7)
        }
        return null
    }
}