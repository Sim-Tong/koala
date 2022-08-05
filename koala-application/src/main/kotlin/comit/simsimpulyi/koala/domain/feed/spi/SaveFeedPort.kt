package comit.simsimpulyi.koala.domain.feed.spi

import comit.simsimpulyi.koala.domain.feed.model.Feed

interface SaveFeedPort {

    fun saveFeed(feed: Feed): Feed

}