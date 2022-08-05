package comit.simsimpulyi.koala.persistence.feed

import comit.simsimpulyi.koala.domain.feed.model.Feed
import comit.simsimpulyi.koala.domain.feed.spi.QueryFeedPort
import comit.simsimpulyi.koala.domain.feed.spi.SaveFeedPort
import java.util.*

class FeedPersistenceAdapter(
    private val feedRepository: FeedRepository
) : SaveFeedPort, QueryFeedPort {

    override fun saveFeed(feed: Feed): Feed {
        TODO("Not yet implemented")
    }

    override fun getFeed(feedId: UUID): Feed {
        TODO("Not yet implemented")
    }

}