package comit.simsimpulyi.koala.persistence.user.entity

import comit.simsimpulyi.koala.domain.user.model.Authority
import comit.simsimpulyi.koala.persistence.BaseUUIDEntity
import org.hibernate.validator.constraints.Length
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_user")
class UserEntity(
    name: String,
    password: String,
    email: String,
    authority: Authority
) : BaseUUIDEntity() {
    @field:NotNull
    @field:Length(max = 10)
    var name = name
        protected set

    @field:NotNull
    @Column(columnDefinition = "CHAR(60)")
    var password = password
        protected set

    @field:NotNull
    var email = email
        protected set

    @field:NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    var authority = authority
        protected set
}