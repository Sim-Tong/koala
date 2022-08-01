package comit.simsimpulyi.koala.persistence.feed.entity

import comit.simsimpulyi.koala.persistence.BaseEntity
import comit.simsimpulyi.koala.persistence.user.entity.UserEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotNull
import javax.validation.constraints.PositiveOrZero

@Entity
@Table(name = "feed")
class FeedEntity(
    @field:NotNull
    @Column(length = 100)
    var title: String,

    @field:NotNull
    @Column(columnDefinition = "LONGTEXT")
    var content: String,

    var isPrivate: Boolean = false,

    @field:PositiveOrZero
    var likeCount: Int = 0,

    @field:NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", columnDefinition = "binary(16)")
    val userId: UserEntity
) : BaseEntity()