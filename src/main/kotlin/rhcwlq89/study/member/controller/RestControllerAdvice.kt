package rhcwlq89.study.member.controller

import rhcwlq89.study.member.domain.dto.common.CommonErrorMessage
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import rhcwlq89.study.member.domain.exception.CommonException
import rhcwlq89.study.member.domain.exception.ErrorCode
import rhcwlq89.study.member.domain.exception.MemberException
import rhcwlq89.study.member.domain.logger

@RestControllerAdvice
class RestControllerAdvice {
    private val logger = logger()

    @ExceptionHandler
    fun methodArgumentNotValidExceptionHandler(e: MethodArgumentNotValidException): ResponseEntity<Any> {
        val error = CommonErrorMessage("Validation", e.message)
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun commonExceptionErrorHandler(request: HttpServletRequest, e: CommonException): ResponseEntity<Any> {
        logger.error {
            "${request.getHeader("Authorization")} Unknown Exception : ${request.method} ${request.requestURI} " +
                    "${request.queryString} ${request.parameterMap} ${e.message}"
        }

        val errorCode = ErrorCode.ERR000
        val error = CommonErrorMessage(errorCode.code, e.message ?: errorCode.message)
        return ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun bookingExceptionErrorHandler(e: MemberException): ResponseEntity<Any> {
        val error = CommonErrorMessage(e.errorCode.code, e.errorCode.message)
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }
}