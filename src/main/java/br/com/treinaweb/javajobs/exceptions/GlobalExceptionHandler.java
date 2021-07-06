package br.com.treinaweb.javajobs.exceptions;

import java.time.LocalDateTime;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.treinaweb.javajobs.dto.ApiError;

@RestControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiError> handleEntityNotFoundException(
        EntityNotFoundException exception, HttpServletRequest request
    ) {
        return getResponseEntity(exception.getLocalizedMessage(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<ApiError> handleEntityExistsException(
        EntityExistsException exception, HttpServletRequest request
    ) {
        return getResponseEntity(exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST, request);
    }

    private ResponseEntity<ApiError> getResponseEntity(String message, HttpStatus status, HttpServletRequest request) {
        var timestamp = LocalDateTime.now();
        var path = request.getRequestURI();

        var apiError = new ApiError(status.value(), timestamp, message, path, null);

        return ResponseEntity
            .status(status)
            .body(apiError);
    }

}
