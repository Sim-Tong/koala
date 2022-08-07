package comit.simsimpulyi.koala.persistence.file

import comit.simsimpulyi.koala.domain.file.spi.QueryFilePort
import comit.simsimpulyi.koala.persistence.file.entity.FileEntity
import comit.simsimpulyi.koala.thirdparty.aws.s3.spi.SaveFilePort
import org.springframework.stereotype.Component
import java.util.*

@Component
class FilePersistenceAdapter(
    private val fileRepository: FileRepository
) : QueryFilePort, SaveFilePort {
    override fun queryAllFile(feedId: UUID): List<String> {
        TODO("Not yet implemented")
    }

    override fun saveFile(file: FileEntity) {
        TODO("Not yet implemented")
    }

}