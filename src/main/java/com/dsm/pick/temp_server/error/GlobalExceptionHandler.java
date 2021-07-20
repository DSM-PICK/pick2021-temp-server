package com.dsm.pick.temp_server.error;

import com.dsm.pick.temp_server.error.exception.BusinessException;
import com.dsm.pick.temp_server.error.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> BusinessExceptionHandler(BusinessException exception) {
        ErrorCode errorCode = exception.getErrorCode();
        return new ResponseEntity<>(new ErrorResponse(errorCode),
                HttpStatus.valueOf(errorCode.getStatus()));
    }

}
