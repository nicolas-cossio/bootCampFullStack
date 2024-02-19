package com.codigo.msregistro.application.controller;

import com.codigo.msregistro.domain.aggregates.response.ResponseReniec;
import com.codigo.msregistro.domain.ports.in.RestReniecIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/reniec")
@RequiredArgsConstructor
public class ReniecController {
    private final RestReniecIn restReniecIn;

    @GetMapping("/inforeniec/{numDoc}")
    public ResponseEntity<ResponseReniec> registrar(@PathVariable String numDoc) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(restReniecIn.getInfoIn(numDoc));
    }
}
