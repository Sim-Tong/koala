package comit.simsimpulyi.koala.domain.feed.model

import comit.simsimpulyi.koala.global.annotation.Aggregate
import java.util.*

@Aggregate
class File(
    val id: UUID,
    val path: String,
    val feedId: UUID
)