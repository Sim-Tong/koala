package comit.simsimpulyi.koala.thirdparty.aws.s3

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties("aws.s3")
@ConstructorBinding
class AwsS3Properties(
    val bucket: String
)