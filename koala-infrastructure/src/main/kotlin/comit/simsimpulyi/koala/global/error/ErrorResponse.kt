package comit.simsimpulyi.koala.global.error

import org.springframework.validation.BindingResult
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import javax.validation.ConstraintViolation
import javax.validation.Path

class ErrorResponse(
    val status: Int,
    val message: String,
    val reason: String
) {

    companion object {
        fun of(exception: ErrorProperty) = this.of(
            exception = exception,
            reason = ""
        )

        fun of(bindingResult: BindingResult): ErrorResponse {
            val errorMap = bindingResult.fieldErrors.associate { it.field to it.defaultMessage }

            return this.of(
                exception = GlobalErrorCode.BAD_REQUEST,
                reason = errorMap.toString()
            )
        }

        fun of(violations: Set<ConstraintViolation<*>>): ErrorResponse {
            val reason = violations.associate { propertyName(it.propertyPath) to it.message }

            return this.of(
                exception = GlobalErrorCode.BAD_REQUEST,
                reason = reason.toString()
            )
        }

        fun of(exception: MethodArgumentTypeMismatchException): ErrorResponse {
            val reason = exception.name + ":" + exception.errorCode + ":" + exception.value

            return this.of(
                exception = GlobalErrorCode.BAD_REQUEST,
                reason = reason
            )
        }

        private fun of(exception: ErrorProperty, reason: String) = ErrorResponse(
            status = exception.status(),
            message = exception.message(),
            reason = reason
        )

        private fun propertyName(path: Path): String {
            val pathToString = path.toString()
            return pathToString.substring(pathToString.lastIndexOf('.') + 1)
        }
    }
}