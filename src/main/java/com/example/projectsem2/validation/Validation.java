package com.example.projectsem2.validation;


import com.example.projectsem2.dto.responseObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@ControllerAdvice
public class Validation  extends ResponseEntityExceptionHandler {

        @Override
        public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                   HttpHeaders headers,
                                                                   HttpStatus status,
                                                                   WebRequest request) {

            Map<String, String> errors = new HashMap<>();
            ex.getBindingResult().getAllErrors().forEach((error) -> {

                String fieldName = ((FieldError) error).getField();
                String message = error.getDefaultMessage();
                errors.put(fieldName, message);
            });
            return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
        }


        @ExceptionHandler({ConstraintViolationException.class})
        public ResponseEntity<Object> handleConstraintViolation(
                ConstraintViolationException ex, WebRequest request) {
            List<String> errors = new ArrayList<String>();
            for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
                errors.add(violation.getRootBeanClass().getName() + " "
                        + violation.getPropertyPath() + ": "
                        + violation.getMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new responseObject("false","da xay ra loi",errors));
        }
}
