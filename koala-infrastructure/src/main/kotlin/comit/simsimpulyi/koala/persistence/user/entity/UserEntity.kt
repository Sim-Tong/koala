package comit.simsimpulyi.koala.persistence.user.entity

import comit.simsimpulyi.koala.domain.user.model.Authority
import comit.simsimpulyi.koala.persistence.BaseEntity
import org.hibernate.validator.constraints.Length
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "user")
class UserEntity(
    @field:NotNull
    @field:Length(max = 10)
    var name: String,

    @field:NotNull
    @Column(columnDefinition = "CHAR(60)")
    var password: String,

    @field:NotNull
    var email: String,

    @field:NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    var authority: Authority
) : BaseEntity()