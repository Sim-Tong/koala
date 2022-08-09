package comit.simsimpulyi.koala.persistence.feed.mapper

import comit.simsimpulyi.koala.domain.feed.model.Feed
import comit.simsimpulyi.koala.persistence.BaseMapper
import comit.simsimpulyi.koala.persistence.feed.entity.FeedEntity
import comit.simsimpulyi.koala.persistence.file.FilePersistenceAdapter
import comit.simsimpulyi.koala.persistence.user.UserPersistenceAdapter
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.springframework.beans.factory.annotation.Autowired

@Mapper
abstract class FeedMapper : BaseMapper<FeedEntity, Feed> {

    @Autowired
    protected lateinit var userPersistenceAdapter: UserPersistenceAdapter

    @Autowired
    protected lateinit var filePersistenceAdapter: FilePersistenceAdapter

    @Mapping(target = "writerId", expression = "java(entity.getWriter().getId())")
    @Mapping(target = "filePaths", expression = "java(filePersistenceAdapter.queryFileList(entity.getId()))")
    abstract override fun toDomain(entity: FeedEntity): Feed

    @Mapping(target = "writer", expression = "java(userPersistenceAdapter.queryUserEntityById(model.getWriterId()))")
    abstract override fun toEntity(model: Feed): FeedEntity
}
