package comit.simsimpulyi.koala.domain.like.spi

import comit.simsimpulyi.koala.domain.like.model.Like
import java.util.*

interface QueryLikePort {

    fun queryLike(userId: UUID, feedId: UUID): Like

    fun queryLikeAllByUser(userId: UUID): List<Like>

    fun queryLikeAllByFeed(feedId: UUID): List<Like>

}