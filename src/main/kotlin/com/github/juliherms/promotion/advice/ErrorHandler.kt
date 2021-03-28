package com.github.juliherms.promotion.advice

import com.fasterxml.jackson.core.JsonParseException
import com.github.juliherms.promotion.model.ErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * This class responsible to capture exception in api
 */
@ControllerAdvice
class ErrorHandler {
    /**
     * Process JsonParseException
     */
    @ExceptionHandler(JsonParseException::class)
    fun jsonParseExceptionHandler(servletRequest: HttpServletRequest, servletResponse: HttpServletResponse, exception: Exception): ResponseEntity<ErrorMessage> {
        return ResponseEntity(ErrorMessage("JSON ERROR",exception.message ?: "invalid json"), HttpStatus.BAD_REQUEST)
    }
}