package comit.simsimpulyi.koala.global.security

import comit.simsimpulyi.koala.global.filter.FilterConfig
import comit.simsimpulyi.koala.global.security.token.JwtInterpreter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig(
    private val jwtInterpreter: JwtInterpreter
) {

    @Bean
    protected fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .cors().and()
            .csrf().disable()
            .formLogin().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http
            .authorizeRequests()

            .anyRequest().authenticated()

        http
            .apply(FilterConfig(jwtInterpreter))

        return http.build()
    }

    @Bean
    protected fun PasswordEncoder() : PasswordEncoder {
        return BCryptPasswordEncoder();
    }
}