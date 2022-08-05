package comit.simsimpulyi.koala.domain.feed.spi

import comit.simsimpulyi.koala.domain.feed.model.Feed
import java.util.*

interface QueryFeedPort {

    fun getFeed(feedId: UUID): Feed

}