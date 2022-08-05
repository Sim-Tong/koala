package comit.simsimpulyi.koala.domain.like.spi

import comit.simsimpulyi.koala.domain.like.model.Like
import java.util.*

interface QueryLikePort {

    fun getLike(userId: UUID, feedId: UUID): Like

    fun getLikeAllByUser(userId: UUID): List<Like>

    fun getLikeAllByFeed(feedId: UUID): List<Like>
}