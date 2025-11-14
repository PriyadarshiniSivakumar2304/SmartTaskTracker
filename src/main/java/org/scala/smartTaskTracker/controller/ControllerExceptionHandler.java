package org.scala.smartTaskTracker.controller;

import org.scala.smartTaskTracker.exception.APIError;
import org.scala.smartTaskTracker.exception.InternalApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public final ResponseEntity<APIError> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException e, WebRequest request) {

        APIError err = new APIError();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage("Bad Request, ensure the request maps to one of our endpoints.");
        return new ResponseEntity<>(err, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(InternalApiException.class)
    public final ResponseEntity<APIError> handleApiError(InternalApiException e, WebRequest request) {
        APIError err = new APIError();
        err.setMessage(e.getMessage());
        err.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

}
