package comit.simsimpulyi.koala.persistence.user

import comit.simsimpulyi.koala.persistence.user.entity.UserEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserRepository : CrudRepository<UserEntity, UUID> {
}