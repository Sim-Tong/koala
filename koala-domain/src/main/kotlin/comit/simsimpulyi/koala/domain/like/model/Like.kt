package comit.simsimpulyi.koala.domain.like.model

import comit.simsimpulyi.koala.global.annotation.Aggregate
import java.util.*

@Aggregate
class Like(
    val feedId: UUID,

    val userId: UUID
)