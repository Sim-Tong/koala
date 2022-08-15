package comit.simsimpulyi.koala.global.error

import org.springframework.http.HttpStatus
import org.springframework.validation.BindException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import javax.validation.ConstraintViolationException


@RestControllerAdvice
class GlobalErrorHandler {

    /**
     * ModelAttribute 에서 binding error 발생시 BindException 발생
     */
    @ExceptionHandler(BindException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected fun handleBindException(ex: BindException): ErrorResponse? {
        return ErrorResponse.of(ex.bindingResult)
    }

    /**
     * Valid 또는 Validated 으로 binding error 발생시 발생
     * HttpMessageConverter 에서 등록한 HttpMessageConverter binding 이 실패하는 경우 발생
     * 보통 @RequestBody, @RequestPart 어노테이션에서 발생
     */
    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected fun handleMethodArgumentNotValidException(
        ex: MethodArgumentNotValidException
    ): ErrorResponse? {
        return ErrorResponse.of(ex.bindingResult)
    }

    /**
     * type 이 일치하지 않아 binding 하지 못할 경우 발생
     * 보통 @RequestParam 요청을 enum 으로 binding 못했을 경우 발생
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected fun handleMethodArgumentTypeMismatchException(
        exception: MethodArgumentTypeMismatchException
    ): ErrorResponse? {
        return ErrorResponse.of(exception)
    }

    /**
     * javax.validation 을 통과하지 못하면 에러가 발생
     * 보통 @NotBlank, @NotEmpty, @NotNull 에서 발생
     */
    @ExceptionHandler(ConstraintViolationException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected fun handleConstraintViolationException(
        ex: ConstraintViolationException
    ): ErrorResponse? {
        return ErrorResponse.of(ex.constraintViolations)
    }

    /**
     * 적합하지 않거나 적절하지 못한 인자를 메서드에 넘기면 발생
     */
    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected fun handleIllegalArgumentException(ex: IllegalArgumentException): ErrorResponse? {
        return ErrorResponse.of(GlobalErrorCode.BAD_REQUEST)
    }
}