package com.otavioyukio.school_manager_api.commons.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public final ResponseEntity<Object>
    handleObjectNotFoundException(ObjectNotFoundException ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("error", ex.getMessage());
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InconsistentDataException.class)
    public final ResponseEntity<Object>
    handleInconsistentDataException(ObjectNotFoundException ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("error", ex.getMessage());
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }
}
