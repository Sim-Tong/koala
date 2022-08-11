package comit.simsimpulyi.koala.global.security

import comit.simsimpulyi.koala.global.filter.FilterConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val filterConfig: FilterConfig
) {

    @Bean
    protected fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .cors().and()
            .csrf().disable()
            .formLogin().disable()

            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()

            .authorizeRequests()

            .anyRequest().authenticated()
            .and()

            .addFilterAfter(filterConfig(), )
            .build()
    }

    @Bean
    protected fun PasswordEncoder() : PasswordEncoder {
        return BCryptPasswordEncoder();
    }
}