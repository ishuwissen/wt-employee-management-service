package com.wissen.exception;

import com.google.common.collect.Lists;
import com.wissen.model.response.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CentralExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> employeeNotFoundException(EmployeeNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<List<Error>> handleInvalidArgumentException(MethodArgumentNotValidException ex) {
        final List<Error> errors= ex.getBindingResult().getFieldErrors().stream().map(e -> Error.builder()
                .errorMessage(e.getDefaultMessage())
                .field(e.getField())
                .build()).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<List<Error>> handleConstraintViolationException(ConstraintViolationException ex) {
        final List<Error> errors= ex.getConstraintViolations().stream().map(e -> Error.builder()
                .errorMessage(e.getMessage())
                .build()).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }

    @ExceptionHandler(EmployeeExcelValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<List<Error>> handleEmployeeExcelValidationException(EmployeeExcelValidationException ex) {
        Error error = Error.builder()
                .errorMessage(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Lists.newArrayList(error));
    }

    @ExceptionHandler(DataAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<List<Error>> handleDataAlreadyExistException(DataAlreadyExistException ex) {
        Error error = Error.builder()
                .errorMessage(ex.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Lists.newArrayList(error));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<List<Error>> handleEmployeeEntityNotFoundException(EntityNotFoundException ex) {
        Error error = Error.builder()
                .errorMessage(ex.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Lists.newArrayList(error));
    }
}
