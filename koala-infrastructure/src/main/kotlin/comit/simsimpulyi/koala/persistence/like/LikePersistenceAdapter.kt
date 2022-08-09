package comit.simsimpulyi.koala.persistence.like

import comit.simsimpulyi.koala.domain.like.model.Like
import comit.simsimpulyi.koala.domain.like.spi.QueryLikePort
import comit.simsimpulyi.koala.domain.like.spi.SaveLikePort
import org.springframework.stereotype.Component
import java.util.*

@Component
class LikePersistenceAdapter(
    private val likeRepository: LikeRepository
) : SaveLikePort, QueryLikePort {

    override fun saveLike(like: Like): Like {
        TODO("Not yet implemented")
    }

    override fun queryLike(userId: UUID, feedId: UUID): Like {
        TODO("Not yet implemented")
    }

    override fun queryLikeAllByUser(userId: UUID): List<Like> {
        TODO("Not yet implemented")
    }

    override fun queryLikeAllByFeed(feedId: UUID): List<Like> {
        TODO("Not yet implemented")
    }

}