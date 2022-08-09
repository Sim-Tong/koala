package comit.simsimpulyi.koala.domain.feed.model

import comit.simsimpulyi.koala.global.annotation.Aggregate
import java.util.*

@Aggregate
class Feed(
    val id: UUID,

    val title: String,

    val content: String,

    val isPrivate: Boolean,

    val writerId: UUID,

    val likeCount: Int,

    val filePaths: List<String>
) {

    fun updateTitleAndContent(title: String, content: String): Feed {
        return Feed(
            id = this.id,
            title = title,
            content = content,
            isPrivate = this.isPrivate,
            writerId = this.writerId,
            likeCount = this.likeCount,
            filePaths = this.filePaths
        )
    }
}