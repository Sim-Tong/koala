package comit.simsimpulyi.koala.persistence.feed.mapper

import comit.simsimpulyi.koala.domain.feed.model.Feed
import comit.simsimpulyi.koala.persistence.BaseMapper
import comit.simsimpulyi.koala.persistence.feed.entity.FeedEntity
import comit.simsimpulyi.koala.persistence.user.UserRepository
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring", imports = [UserRepository::class])
interface FeedMapper : BaseMapper<FeedEntity, Feed> {

    @Mapping(target = "writerId", expression = "java(entity.getWriter().getId())")
    override fun toDomain(entity: FeedEntity): Feed

    @Mapping(target = "writer", expression = "java(new UserRepository().queryUserEntityById(model.getWriterId()))")
    override fun toEntity(model: Feed): FeedEntity
}

