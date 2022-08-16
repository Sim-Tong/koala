package comit.simsimpulyi.koala.global.error

abstract class BusinessException(
    val exceptionProperty: ErrorProperty
) : RuntimeException()