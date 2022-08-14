package comit.simsimpulyi.koala.global.filter

import comit.simsimpulyi.koala.global.security.token.JwtInterpreter
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
class FilterConfig (
    private val filterTokenAdapter: JwtInterpreter
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {
        builder.addFilterBefore(JwtFilter(filterTokenAdapter), UsernamePasswordAuthenticationFilter::class.java)
    }
}