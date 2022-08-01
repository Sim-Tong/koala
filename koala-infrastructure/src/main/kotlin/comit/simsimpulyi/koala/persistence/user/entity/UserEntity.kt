package comit.simsimpulyi.koala.persistence.user.entity

import comit.simsimpulyi.koala.domain.user.model.Authority
import comit.simsimpulyi.koala.persistence.BaseEntity
import comit.simsimpulyi.koala.persistence.feed.entity.FeedEntity
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "user")
class UserEntity(
    @field:NotNull
    @Column(length = 20)
    var name: String,

    @field:NotNull
    @Column(length = 60)
    var password: String,

    @field:NotNull
    var email: String,

    @field:NotNull
    @Enumerated
    var authority: Authority
): BaseEntity() {
    @OneToMany
    val myFeed: Set<FeedEntity> = mutableSetOf()
}