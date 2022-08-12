package comit.simsimpulyi.koala.global.security

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.ConstructorBinding
import java.util.*

@ConfigurationPropertiesScan("spring.security")
@ConstructorBinding
class SecurityProperties(
    secretKey: String,
    accessTime: Int,
    refreshTime: Int
) {
    val accessExpire = accessTime * 1000
    val refreshExpire = refreshTime * 1000
    val secretKey = Base64.getEncoder().encodeToString(secretKey.padStart(64).toByteArray())!!
}