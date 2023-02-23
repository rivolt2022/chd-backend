package com.ot.backend.config;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@RestControllerAdvice(annotations = {RestController.class, Service.class})
public class ExceptionHelper {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAll(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.ok().body(ErrorInfo.ERROR);
    }

    @ExceptionHandler({SQLException.class, RuntimeException.class, CommonException.class})
    public ResponseEntity<Object> handleQueryException(CommonException ex) {
        return ResponseEntity.ok().body(ex.getMessage());
    }
}
