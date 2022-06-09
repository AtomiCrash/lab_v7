package com.example.labs.ErrorLog;

import com.example.labs.exceptions.BadRequestException;
import com.example.labs.exceptions.ServerException;
import com.example.labs.response.Response;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorLog extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Response> handleException(@NonNull BadRequestException ex) {
        logger.error("ERROR CODE 400", ex);
        return new ResponseEntity<>(new Response(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ServerException.class)
    public ResponseEntity<Response> handleException(@NonNull Exception ex) {
        logger.error("ERROR CODE 500", ex);
        return new ResponseEntity<>(new Response(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
