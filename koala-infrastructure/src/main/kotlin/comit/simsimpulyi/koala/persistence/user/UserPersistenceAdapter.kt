package comit.simsimpulyi.koala.persistence.user

import comit.simsimpulyi.koala.domain.user.model.User
import comit.simsimpulyi.koala.domain.user.spi.QueryUserPort
import comit.simsimpulyi.koala.domain.user.spi.SaveUserPort
import comit.simsimpulyi.koala.persistence.user.entity.UserEntity
import comit.simsimpulyi.koala.persistence.user.mapper.UserMapper
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserPersistenceAdapter(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) : SaveUserPort, QueryUserPort {

    override fun saveUser(user: User): User {
        val entity = userRepository.save(userMapper.toEntity(user))
        return userMapper.toDomain(entity)
    }

    override fun queryUserById(userId: UUID): User {
        return userMapper.toDomain(queryUserEntityById(userId))
    }

    fun queryUserEntityById(userId: UUID): UserEntity {
        return userRepository.queryUserEntityById(userId)
    }

}