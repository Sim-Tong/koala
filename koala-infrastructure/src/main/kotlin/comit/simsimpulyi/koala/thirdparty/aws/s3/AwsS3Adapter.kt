package comit.simsimpulyi.koala.thirdparty.aws.s3

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.PutObjectRequest
import comit.simsimpulyi.koala.domain.feed.spi.UploadFilePort
import org.springframework.stereotype.Component
import java.io.File
import java.util.*

@Component
class AwsS3Adapter(
    private val amazonS3Client: AmazonS3Client,
    private val awsS3Properties: AwsS3Properties
) : UploadFilePort {

    override fun uploadFile(file: File): String {
        val fileKey = "${UUID.randomUUID()}@${file.name}"

        amazonS3Client.putObject(
            PutObjectRequest(awsS3Properties.bucket, fileKey, file)
                .withCannedAcl(CannedAccessControlList.AuthenticatedRead))
        return amazonS3Client.getResourceUrl(awsS3Properties.bucket, fileKey)
    }

}