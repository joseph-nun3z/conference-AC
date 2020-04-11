package org.escoladecodigo.rhashtafaris.conferenceacademy.config;

import org.escoladecodigo.rhashtafaris.conferenceacademy.exception.SpeakerNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler  extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        List<String> errorList = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach(e -> {
            String message = e.getDefaultMessage();
            errorList.add(message);
        });

        body.put("errors", errorList);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SpeakerNotFoundException.class)
    protected ResponseEntity<?> notFoundHandler(final SpeakerNotFoundException ex){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
