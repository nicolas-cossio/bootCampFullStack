package com.codigo.msregistro.application.middleware;

import com.codigo.msregistro.domain.aggregates.response.ResponseError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestMiddleware {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> errorResponseEntity(Exception e) {
        return ResponseEntity.status(422).body(new ResponseError(2422, e.getCause().toString()));
    }

}
