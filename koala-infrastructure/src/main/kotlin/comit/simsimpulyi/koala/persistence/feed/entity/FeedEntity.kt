package comit.simsimpulyi.koala.persistence.feed.entity

import comit.simsimpulyi.koala.persistence.BaseEntity
import comit.simsimpulyi.koala.persistence.user.entity.UserEntity
import org.hibernate.annotations.ColumnDefault
import org.hibernate.validator.constraints.Length
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.PositiveOrZero

@Entity
@Table(name = "tb_feed")
class FeedEntity(
    @field:NotNull
    @field:Length(max = 100)
    var title: String,

    @field:NotNull
    @Column(columnDefinition = "LONGTEXT")
    var content: String,

    @ColumnDefault("false")
    @Column(nullable = false)
    var isPrivate: Boolean? = false,

    @field:NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)")
    val writer: UserEntity
) : BaseEntity() {

    @field:NotNull
    @field:PositiveOrZero
    @ColumnDefault("0")
    @Column(columnDefinition = "INT UNSIGNED")
    var likeCount: Int = 0

}