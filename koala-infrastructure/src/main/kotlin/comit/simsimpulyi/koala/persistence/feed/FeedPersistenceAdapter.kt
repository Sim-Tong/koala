package comit.simsimpulyi.koala.persistence.feed

import comit.simsimpulyi.koala.domain.feed.model.Feed
import comit.simsimpulyi.koala.domain.feed.spi.QueryFeedPort
import comit.simsimpulyi.koala.domain.feed.spi.SaveFeedPort
import org.springframework.stereotype.Component
import java.util.*

@Component
class FeedPersistenceAdapter(
    private val feedRepository: FeedRepository
) : SaveFeedPort, QueryFeedPort {

    override fun saveFeed(feed: Feed): Feed {
        TODO("Not yet implemented")
    }

    override fun queryFeed(feedId: UUID): Feed {
        TODO("Not yet implemented")
    }

}