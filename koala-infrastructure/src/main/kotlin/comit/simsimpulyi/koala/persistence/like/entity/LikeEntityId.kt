package comit.simsimpulyi.koala.persistence.like.entity

import java.io.Serializable
import java.util.*

data class LikeEntityId(
    val user: UUID,
    val feed: UUID
): Serializable