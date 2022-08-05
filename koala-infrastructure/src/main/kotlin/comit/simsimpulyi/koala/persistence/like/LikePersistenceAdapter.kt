package comit.simsimpulyi.koala.persistence.like

import comit.simsimpulyi.koala.domain.like.model.Like
import comit.simsimpulyi.koala.domain.like.spi.SaveLikePort

class LikePersistenceAdapter(
    private val likeRepository: LikeRepository
) : SaveLikePort {

    override fun saveLike(like: Like): Unit {
        TODO("Not yet implemented")
    }
}