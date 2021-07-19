package com.practice.graphql.exceptions;

import com.practice.graphql.api.responses.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {RuntimeException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ExceptionResponse runtimeExceptionHandler(final RuntimeException exception) {
        final ExceptionResponse exceptionResponse = new ExceptionResponse();

        exceptionResponse.setMessage(exception.getMessage());

        return exceptionResponse;
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ExceptionResponse illegalArgumentExceptionHandler(final RuntimeException exception) {
        final ExceptionResponse exceptionResponse = new ExceptionResponse();

        exceptionResponse.setMessage(exception.getMessage());

        return exceptionResponse;
    }

}
