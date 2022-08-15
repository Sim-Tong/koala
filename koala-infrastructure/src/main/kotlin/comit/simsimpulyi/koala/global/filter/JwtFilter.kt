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
        val token = resolveToken(request)
        token?.let {
            val authentication = jwtParser.getAuthentication(it)
            SecurityContextHolder.getContext().authentication = authentication
        }
        filterChain.doFilter(request, response)
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearer = request.getHeader(JwtComponent.JWT_HEADER)
        if(bearer.isNotEmpty().and(bearer.startsWith(JwtComponent.JWT_PREFIX))) {
            return bearer.substring(7)
        }
        return null
    }
}