package comit.simsimpulyi.koala.persistence.feed.mapper

import comit.simsimpulyi.koala.domain.feed.model.Feed
import comit.simsimpulyi.koala.persistence.BaseMapper
import comit.simsimpulyi.koala.persistence.feed.entity.FeedEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface FeedMapper : BaseMapper<FeedEntity, Feed> {

    override fun toDomain(entity: FeedEntity): Feed {
        TODO("Not yet implemented")
    }

    override fun toEntity(model: Feed): FeedEntity {
        TODO("Not yet implemented")
    }
}