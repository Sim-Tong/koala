package comit.simsimpulyi.koala.persistence.like.entity

import comit.simsimpulyi.koala.persistence.feed.entity.FeedEntity
import comit.simsimpulyi.koala.persistence.user.entity.UserEntity
import java.io.Serializable
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.validation.constraints.NotNull

data class LikeEntityId(
    @field:NotNull
    @ManyToOne
    @JoinColumn(columnDefinition = "BINARY(16)")
    val user: UserEntity,

    @field:NotNull
    @ManyToOne
    @JoinColumn(columnDefinition = "BINARY(16)")
    val feed: FeedEntity
) : Serializable