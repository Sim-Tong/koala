package comit.simsimpulyi.koala.persistence.file.entity

import comit.simsimpulyi.koala.persistence.BaseUUIDEntity
import comit.simsimpulyi.koala.persistence.feed.entity.FeedEntity
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_file")
class FileEntity(
    @field:NotNull
    val path: String,

    @field:NotNull
    @ManyToOne
    @JoinColumn(columnDefinition = "BINARY(16)")
    val feed: FeedEntity
): BaseUUIDEntity()