package comit.simsimpulyi.koala.persistence.token.entity

import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import java.util.*
import javax.persistence.Id

@RedisHash
class RefreshToken(

    @Id
    val token: String,

    @TimeToLive
    val expireTime: Int,

    val userId: UUID

)