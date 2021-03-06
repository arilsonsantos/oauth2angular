package br.com.orion.oauth2angular.exceptions;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(e -> errors.put(e.getField(), e.getDefaultMessage()));
        

        ValidationErrorDetail error = ValidationErrorDetail.builder()
        .statusCode(status.value())
        .message(ex.getMessage())
        .errors(errors)
        .build();
        return new ResponseEntity<>(error, status);
    }
    
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<?> handleResourceAlreadyExistsException(ResourceAlreadyExistsException ex) {

        ErrorDetail error = ErrorDetail.builder()
        .statusCode(HttpStatus.BAD_REQUEST.value())
        .message(ex.getMessage())
                .build();
        
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetail> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {

        ErrorDetail error = ErrorDetail.builder()
        .statusCode(HttpStatus.NOT_FOUND.value())
        .path(request.getRequestURI())
        .message(ex.getMessage())
                .build();
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

   

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException ex) {

        ErrorDetail error = ErrorDetail.builder()
        .statusCode(HttpStatus.BAD_REQUEST.value())
        .message(ex.getMessage())
                .build();
        
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    
    
    
}