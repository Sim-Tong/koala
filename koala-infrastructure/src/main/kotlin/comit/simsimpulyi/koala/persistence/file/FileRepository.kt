package comit.simsimpulyi.koala.persistence.file

import comit.simsimpulyi.koala.persistence.file.entity.FileEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FileRepository : CrudRepository<FileEntity, UUID> {

    @Query("select f.path from FileEntity f where f.feed.id = :feedId")
    fun queryPathByFeedId(feedId: UUID): List<String>

}