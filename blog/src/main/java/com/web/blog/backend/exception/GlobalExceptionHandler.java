package com.web.blog.backend.exception;

import com.web.blog.backend.util.DataResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<DataResponse<?>> handleGlobalError(Exception ex) {
        DataResponse<?> dataResponse = new DataResponse<>(false, ex.getMessage());
        return new ResponseEntity<>(dataResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
