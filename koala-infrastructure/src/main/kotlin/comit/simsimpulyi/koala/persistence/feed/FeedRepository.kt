package comit.simsimpulyi.koala.persistence.feed

import comit.simsimpulyi.koala.persistence.feed.entity.FeedEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface FeedRepository : CrudRepository<FeedEntity, UUID> {
}