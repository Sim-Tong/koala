package comit.simsimpulyi.koala.persistence.like

import comit.simsimpulyi.koala.domain.like.model.Like
import comit.simsimpulyi.koala.domain.like.spi.LikePersistencePort
import comit.simsimpulyi.koala.global.annotation.Adapter

@Adapter
class LikePersistenceAdapter(
    private val likeRepository: LikeRepository
) : LikePersistencePort {

    override fun saveLike(like: Like): Unit {
        TODO("Not yet implemented")
    }
}