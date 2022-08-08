package comit.simsimpulyi.koala.persistence.feed

import comit.simsimpulyi.koala.persistence.feed.entity.FeedEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FeedRepository : CrudRepository<FeedEntity, UUID> {

    fun queryById(id: UUID): FeedEntity
}