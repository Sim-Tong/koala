package comit.simsimpulyi.koala.domain.feed.spi

import java.io.File

interface UploadFilePort {

    fun uploadFile(file: File): String
}