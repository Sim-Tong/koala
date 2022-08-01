package comit.simsimpulyi.koala.persistence

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import javax.validation.constraints.NotNull

@MappedSuperclass
abstract class BaseEntity (
    @field:NotNull
    val createDate: LocalDateTime = LocalDateTime.now(),

    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()
)