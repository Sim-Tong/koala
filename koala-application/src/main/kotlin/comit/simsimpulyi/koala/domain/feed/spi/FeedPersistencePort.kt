package comit.simsimpulyi.koala.domain.feed.spi

import comit.simsimpulyi.koala.domain.feed.model.Feed
import comit.simsimpulyi.koala.global.annotation.Port
import java.util.*

@Port
interface FeedPersistencePort {

    fun saveFeed(feed: Feed): Feed

    fun getFeed(feedId: UUID): Feed
}