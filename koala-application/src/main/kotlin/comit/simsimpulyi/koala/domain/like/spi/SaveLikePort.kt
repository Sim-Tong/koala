package comit.simsimpulyi.koala.domain.like.spi

import comit.simsimpulyi.koala.domain.like.model.Like

interface SaveLikePort {

    fun saveLike(like: Like): Like

}