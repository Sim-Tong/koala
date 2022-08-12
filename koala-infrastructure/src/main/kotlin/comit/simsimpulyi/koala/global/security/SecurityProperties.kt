package comit.simsimpulyi.koala.global.security

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.util.*

@ConfigurationProperties("spring.security")
@ConstructorBinding
class SecurityProperties(
    secretKey: String,
    accessTime: Int,
    refreshTime: Int
) {
    val accessExpire = accessTime * 1000
    val refreshExpire = refreshTime * 1000
    val secretKey = Base64.getEncoder().encodeToString(secretKey.toByteArray())!!
}