package comit.simsimpulyi.koala.persistence.user.mapper

import comit.simsimpulyi.koala.domain.user.model.User
import comit.simsimpulyi.koala.persistence.BaseMapper
import comit.simsimpulyi.koala.persistence.user.entity.UserEntity
import org.mapstruct.Mapper

@Mapper
interface UserMapper : BaseMapper<UserEntity, User> {

}