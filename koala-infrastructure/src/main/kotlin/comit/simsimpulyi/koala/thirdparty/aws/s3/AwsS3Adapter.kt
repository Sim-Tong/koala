package comit.simsimpulyi.koala.thirdparty.aws.s3

import comit.simsimpulyi.koala.domain.file.spi.UploadFilePort
import comit.simsimpulyi.koala.thirdparty.aws.s3.spi.SaveFilePort
import org.springframework.stereotype.Component

@Component
class AwsS3Adapter(
    private val saveFilePort: SaveFilePort,
) : UploadFilePort {
    override fun storeFile() {
        TODO("Not yet implemented")
    }

    override fun uploadFile() {
        TODO("Not yet implemented")
    }


}