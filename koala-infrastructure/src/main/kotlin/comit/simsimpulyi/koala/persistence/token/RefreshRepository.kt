package comit.simsimpulyi.koala.persistence.token

import comit.simsimpulyi.koala.persistence.token.entity.RefreshToken
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RefreshRepository : CrudRepository<RefreshToken, String> {
}