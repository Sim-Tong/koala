package comit.simsimpulyi.koala.thirdparty.aws.s3.spi

import comit.simsimpulyi.koala.persistence.file.entity.FileEntity

interface SaveFilePort {

    fun saveFile(file: FileEntity)
}