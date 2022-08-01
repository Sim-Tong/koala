package comit.simsimpulyi.koala.persistence.user.entity

import comit.simsimpulyi.koala.domain.user.model.Authority
import comit.simsimpulyi.koala.persistence.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Enumerated
import javax.persistence.Table
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
) : BaseEntity()