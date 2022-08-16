package comit.simsimpulyi.koala.persistence.feed.mapper

import comit.simsimpulyi.koala.domain.feed.model.Feed
import comit.simsimpulyi.koala.persistence.BaseMapper
import comit.simsimpulyi.koala.persistence.feed.entity.FeedEntity
import comit.simsimpulyi.koala.persistence.file.FileRepository
import comit.simsimpulyi.koala.persistence.user.UserPersistenceAdapter
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.springframework.beans.factory.annotation.Autowired

@Mapper
abstract class FeedMapper : BaseMapper<FeedEntity, Feed> {

    @Autowired
    protected lateinit var userPersistenceAdapter: UserPersistenceAdapter

    @Autowired
    protected lateinit var fileRepository: FileRepository

    @Mappings(
        Mapping(target = "writerId", expression = "java(entity.getWriter().getId())"),
        Mapping(target = "filePaths", expression = "java(fileRepository.queryPathByFeedId(entity.getId()))")
    )
    abstract override fun toDomain(entity: FeedEntity): Feed

    @Mapping(target = "writer", expression = "java(userPersistenceAdapter.queryUserEntityById(model.getWriterId()))")
    abstract override fun toEntity(model: Feed): FeedEntity
}
