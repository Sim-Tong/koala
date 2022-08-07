package comit.simsimpulyi.koala.persistence.file

import comit.simsimpulyi.koala.persistence.file.entity.FileEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FileRepository : CrudRepository<FileEntity, UUID> {
}