package comit.simsimpulyi.koala.global.exception

import comit.simsimpulyi.koala.global.error.BusinessException
import comit.simsimpulyi.koala.global.error.GlobalErrorCode

class InternalServerErrorException private constructor() : BusinessException(GlobalErrorCode.INTERNAL_SERVER_ERROR) {

    companion object {
        @JvmField
        val EXCEPTION = InternalServerErrorException()
    }
}