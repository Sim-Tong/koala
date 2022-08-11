package comit.simsimpulyi.koala.persistence.token

import comit.simsimpulyi.koala.persistence.token.entity.RefreshToken
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtPersistenceAdapter(
    private val refreshRepository: RefreshRepository
) {

    fun saveToken(token: String, userId: UUID, exp: Int) {
        refreshRepository.save(
            RefreshToken(
                token = token,
                expireTime = exp,
                userId = userId
            ))
    }
}