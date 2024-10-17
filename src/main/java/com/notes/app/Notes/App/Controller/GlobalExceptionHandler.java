package com.notes.app.Notes.App.Controller;

import com.notes.app.Notes.App.Models.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final <T> ResponseEntity<Response<T>> handleException(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();

        log.error("Handling exception :: {}", ex.getMessage(), ex);

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return handleExceptionInternal(ex, headers, status, request);
    }

    protected <T> ResponseEntity<Response<T>> handleExceptionInternal(Exception ex,
                                                                      HttpHeaders headers, HttpStatus status,
                                                                      WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }

        return new ResponseEntity<>(null, headers, status);
    }

}
