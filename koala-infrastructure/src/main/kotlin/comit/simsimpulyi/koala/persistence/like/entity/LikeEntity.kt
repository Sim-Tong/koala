package comit.simsimpulyi.koala.persistence.like.entity

import comit.simsimpulyi.koala.persistence.BaseTimeEntity
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "tbl_like")
class LikeEntity(
    @EmbeddedId
    val likeId: LikeEntityId
) : BaseTimeEntity()