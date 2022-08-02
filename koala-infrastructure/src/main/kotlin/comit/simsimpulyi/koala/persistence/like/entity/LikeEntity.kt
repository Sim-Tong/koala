package comit.simsimpulyi.koala.persistence.like.entity

import comit.simsimpulyi.koala.persistence.BaseTimeEntity
import java.io.Serializable
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "tbl_like")
class LikeEntity(
    @EmbeddedId
    val key: LikeEntityId
): Serializable, BaseTimeEntity()