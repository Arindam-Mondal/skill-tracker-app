package com.example.skilltracker.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
public class SkillTrackerResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { ConstraintViolationException.class})
    protected ResponseEntity<Object> handleConflict(ConstraintViolationException ex) {
        List<String> validationErrorList = validationErrorList(ex);
        return ResponseEntity.unprocessableEntity().body(validationErrorList);
    }


    private List<String> validationErrorList(ConstraintViolationException ex) {
        return ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
    }

}
