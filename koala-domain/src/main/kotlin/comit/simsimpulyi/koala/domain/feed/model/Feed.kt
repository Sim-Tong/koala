package comit.simsimpulyi.koala.domain.feed.model

import comit.simsimpulyi.koala.global.annotation.Aggregate
import java.util.*

@Aggregate
class Feed(
    val id: UUID,

    val title: String,

    val content: String,

    val isPrivate: Boolean,

    val writer: UUID,

    val likeCount: Int
) {

    fun updateTitleAndContent(title: String, content: String): Feed {
        return Feed(
            id = this.id,
            title = title,
            content = content,
            isPrivate = this.isPrivate,
            writer = this.writer,
            likeCount = this.likeCount
        );
    }
}