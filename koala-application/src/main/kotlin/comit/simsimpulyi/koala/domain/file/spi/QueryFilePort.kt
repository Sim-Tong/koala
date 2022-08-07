package comit.simsimpulyi.koala.domain.file.spi

import java.util.*

interface QueryFilePort {

    fun queryAllFile(feedId: UUID): List<String>
}