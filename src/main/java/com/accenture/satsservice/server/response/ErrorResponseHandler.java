package com.accenture.satsservice.server.response;

import java.time.LocalDateTime;

import com.accenture.satsservice.server.exception.AttendanceException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ErrorResponseHandler {

    public ErrorResponseHandler() {

    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(AttendanceException exc, WebRequest ex) {
        ErrorResponse error = new ErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        if (("Learner not yet timed-in".equals(exc.getMessage()))) {
            error.setError("Not Found");
        } else {
            error.setError("Conflict");
        }
        error.setMessage(exc.getMessage());
        error.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
