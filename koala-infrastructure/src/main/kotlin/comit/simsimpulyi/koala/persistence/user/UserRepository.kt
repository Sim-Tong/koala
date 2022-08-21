package comit.simsimpulyi.koala.persistence.user

import comit.simsimpulyi.koala.persistence.user.entity.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : CrudRepository<UserEntity, UUID> {

    fun queryUserEntityById(id: UUID): UserEntity?

    fun existsByEmail(email: String): Boolean

    fun queryUserEntityByEmail(email: String): UserEntity?
}