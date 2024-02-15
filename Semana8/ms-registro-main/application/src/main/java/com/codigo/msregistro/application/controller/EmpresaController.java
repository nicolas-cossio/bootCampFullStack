package com.codigo.msregistro.application.controller;

import com.codigo.msregistro.domain.aggregates.request.RequestEmpresa;
import com.codigo.msregistro.domain.aggregates.response.ResponseBase;
import com.codigo.msregistro.domain.ports.in.EmpresaServiceIn;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/empresa/")
@RequiredArgsConstructor
public class EmpresaController {
    private final EmpresaServiceIn empresaServiceIn;

    @PostMapping
    public ResponseBase registrar(@RequestBody RequestEmpresa requestEmpresa) {
        return empresaServiceIn.crearEmpresaIn(requestEmpresa);
    }
}
