package comit.simsimpulyi.koala.persistence.like.entity

import comit.simsimpulyi.koala.persistence.feed.entity.FeedEntity
import comit.simsimpulyi.koala.persistence.user.entity.UserEntity
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@IdClass(LikeEntityId::class)
@Table(name = "tb_like")
class LikeEntity(

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)")
    val user: UserEntity,

    @Id
    @ManyToOne
    @JoinColumn(name = "feed_id", columnDefinition = "BINARY(16)")
    val feed: FeedEntity,

    @field:NotNull
    val createDate: LocalDateTime = LocalDateTime.now()
): Serializable