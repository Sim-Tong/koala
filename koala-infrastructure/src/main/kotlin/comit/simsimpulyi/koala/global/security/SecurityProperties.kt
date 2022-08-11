package comit.simsimpulyi.koala.global.security

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.ConstructorBinding
import java.util.*

@ConfigurationPropertiesScan("spring.security")
@ConstructorBinding
class SecurityProperties(
    secret: String,
    accessTime: Int,
    refreshTime: Int
) {
    val accessExpire = accessTime * 1000
    val refreshExpire = refreshTime * 1000
    val secret = Base64.getEncoder().encodeToString(secret.padStart(64).toByteArray())!!
}