package comit.simsimpulyi.koala.persistence.feed

import comit.simsimpulyi.koala.domain.feed.model.Feed
import comit.simsimpulyi.koala.domain.feed.spi.FeedPersistencePort
import java.util.*

class FeedPersistenceAdapter(
    private val feedRepository: FeedRepository
) : FeedPersistencePort {

    override fun saveFeed(feed: Feed): Feed {
        TODO("Not yet implemented")
    }

    override fun getFeed(feedId: UUID): Feed {
        TODO("Not yet implemented")
    }

}