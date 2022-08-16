package comit.simsimpulyi.koala.persistence

interface BaseMapper<ENTITY, DOMAIN> {

    fun toEntity(model: DOMAIN): ENTITY

    fun toDomain(entity: ENTITY): DOMAIN

}