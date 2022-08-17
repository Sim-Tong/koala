package comit.simsimpulyi.koala.persistence.feed

import comit.simsimpulyi.koala.domain.feed.model.Feed
import comit.simsimpulyi.koala.domain.feed.spi.QueryFeedPort
import comit.simsimpulyi.koala.domain.feed.spi.SaveFeedPort
import comit.simsimpulyi.koala.persistence.feed.mapper.FeedMapper
import comit.simsimpulyi.koala.persistence.file.FilePersistenceAdapter
import org.springframework.stereotype.Component
import java.util.*

@Component
class FeedPersistenceAdapter(
    private val feedRepository: FeedRepository,
    private val filePersistenceAdapter: FilePersistenceAdapter,
    private val feedMapper: FeedMapper
) : SaveFeedPort, QueryFeedPort {

    override fun saveFeed(feed: Feed): Feed {
        val entity = feedRepository.save(feedMapper.toEntity(feed))
        filePersistenceAdapter.saveFile(feed.filePaths, entity)

        return feedMapper.toDomain(entity)
    }

    override fun queryFeed(feedId: UUID): Feed {
        val entity = feedRepository.queryById(feedId) ?: throw Exception() // TODO
        return feedMapper.toDomain(entity)
    }
}