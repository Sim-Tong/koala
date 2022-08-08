package comit.simsimpulyi.koala.domain.feed.spi

import comit.simsimpulyi.koala.domain.feed.model.BucketFolder
import java.io.File

interface UploadFilePort {

    fun uploadFile(file: File, folder: BucketFolder): String
}