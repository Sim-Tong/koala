package comit.simsimpulyi.koala.global.filter

import comit.simsimpulyi.koala.global.security.token.FilterTokenAdapter
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
class FilterConfig (
    private val filterTokenAdapter: FilterTokenAdapter
) : AbstractHttpConfigurer<FilterConfig, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {
        builder.addFilterBefore(JwtFilter(filterTokenAdapter), UsernamePasswordAuthenticationFilter::class.java)
    }
}