package comit.simsimpulyi.koala.persistence.file.entity

import comit.simsimpulyi.koala.persistence.BaseTimeEntity
import comit.simsimpulyi.koala.persistence.feed.entity.FeedEntity
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_file")
class FileEntity(
    @Id
    val path: String,

    @field:NotNull
    @ManyToOne
    @JoinColumn(columnDefinition = "BINARY(16)")
    val feed: FeedEntity
): BaseTimeEntity()