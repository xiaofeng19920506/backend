package com.ucomputersa.monolithic.errorhandling;

import com.ucomputersa.monolithic.domain.R;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<R> handleBusinessException(BusinessException ex, HttpServletRequest request) {
        LOGGER.error("handleBusinessException: error code: {}, error message: {}, ex: {}", ex.getCode(), ex.getMessage(), ex.getStackTrace()[0]);
        return ResponseEntity.ok(R.error(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<R> handleGlobalException(Exception ex, HttpServletRequest request) {
        LOGGER.error("handleGlobalException: error message: {}, error message: {}  error: {}", ex.getMessage(), ex.getCause(), ex.getStackTrace());
        return ResponseEntity.badRequest().body(R.error(ErrorCodes.EXCEPTION.code(), ErrorCodes.EXCEPTION.message()));
    }
}