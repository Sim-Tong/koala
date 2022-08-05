package comit.simsimpulyi.koala.persistence.like

import comit.simsimpulyi.koala.persistence.like.entity.LikeEntity
import comit.simsimpulyi.koala.persistence.like.entity.LikeEntityId
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface LikeRepository : CrudRepository<LikeEntity, LikeEntityId> {
}