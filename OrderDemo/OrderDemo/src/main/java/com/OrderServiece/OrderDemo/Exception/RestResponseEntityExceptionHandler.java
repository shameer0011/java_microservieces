package com.OrderServiece.OrderDemo.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.OrderServiece.OrderDemo.External.Response.ErrorResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomeException.class) // Ensure this annotation is used in a @ControllerAdvice class
    public ResponseEntity<ErrorResponse> handleCustomException(CustomeException ex) {

        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorMessage(ex.getMessage())
                .errorCode(ex.getErrorCode())
                .build();

        return new ResponseEntity<>(errorResponse, org.springframework.http.HttpStatus.valueOf(ex.getStatus()));
    }

}
