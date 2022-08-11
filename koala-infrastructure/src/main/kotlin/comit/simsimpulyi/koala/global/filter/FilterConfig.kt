package comit.simsimpulyi.koala.global.filter

import comit.simsimpulyi.koala.global.security.token.JwtAdapter
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain

@Configuration
class FilterConfig (
    private val jwtAdapter: JwtAdapter
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {
        builder.addFilter(JwtFilter(jwtAdapter))
    }
}