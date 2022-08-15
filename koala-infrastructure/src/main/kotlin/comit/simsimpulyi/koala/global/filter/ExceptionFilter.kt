package comit.simsimpulyi.koala.global.filter

import com.fasterxml.jackson.databind.ObjectMapper
import comit.simsimpulyi.koala.global.error.ErrorResponse
import comit.simsimpulyi.koala.global.error.BusinessException
import comit.simsimpulyi.koala.global.error.ErrorProperty
import comit.simsimpulyi.koala.global.exception.InternalServerErrorException
import org.apache.commons.codec.CharEncoding
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (exception: Exception) {
            when (exception) {
                is BusinessException -> writeErrorCode(exception.exceptionProperty, response)
                else -> writeErrorCode(InternalServerErrorException.EXCEPTION.exceptionProperty, response)
            }
        }
    }

    private fun writeErrorCode(exception: ErrorProperty, response: HttpServletResponse) {
        val errorResponse = ErrorResponse.of(exception)

        response.characterEncoding = CharEncoding.UTF_8
        response.status = errorResponse.status
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(objectMapper.writeValueAsString(errorResponse))
    }
}