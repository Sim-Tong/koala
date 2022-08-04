package comit.simsimpulyi.koala.domain.like.spi

import comit.simsimpulyi.koala.domain.like.model.Like
import comit.simsimpulyi.koala.global.annotation.Port

@Port
interface LikePersistencePort {

    fun saveLike(like: Like): Unit
    
}