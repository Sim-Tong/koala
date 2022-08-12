package comit.simsimpulyi.koala.global.filter

import comit.simsimpulyi.koala.global.security.token.FilterTokenAdapter
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtFilter(
    private val filterTokenAdapter: FilterTokenAdapter
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = filterTokenAdapter.resolveToken(request)
        token?.let {
            val authentication = filterTokenAdapter.getAuthentication(it)
            SecurityContextHolder.getContext().authentication = authentication
        }
        filterChain.doFilter(request, response)
    }
}