package comit.simsimpulyi.koala.persistence.feed.entity

import comit.simsimpulyi.koala.persistence.BaseUUIDEntity
import comit.simsimpulyi.koala.persistence.user.entity.UserEntity
import org.hibernate.annotations.ColumnDefault
import org.hibernate.validator.constraints.Length
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotNull
import javax.validation.constraints.PositiveOrZero

@Entity
@Table(name = "tbl_feed")
class FeedEntity(
    title: String,
    content: String,
    isPrivate: Boolean = false,

    @field:NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)")
    val writer: UserEntity
) : BaseUUIDEntity() {

    @field:NotNull
    @field:PositiveOrZero
    @ColumnDefault("0")
    @Column(columnDefinition = "INT UNSIGNED")
    var likeCount: Int = 0
        protected set

    @field:NotNull
    @field:Length(max = 100)
    var title = title
        protected set

    @field:NotNull
    @Column(columnDefinition = "LONGTEXT")
    var content = content
        protected set

    @ColumnDefault("false")
    @Column(nullable = false)
    var isPrivate = isPrivate
        protected set
}