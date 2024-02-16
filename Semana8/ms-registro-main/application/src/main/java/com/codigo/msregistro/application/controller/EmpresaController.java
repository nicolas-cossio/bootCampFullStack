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

    @GetMapping("/{id}")
    public ResponseBase obtener(@PathVariable Long id) {
        return empresaServiceIn.obtenerEmpresaIn(id);
    }

    @GetMapping
    public ResponseBase obtenerTodos() {
        return empresaServiceIn.obtenerTodosIn();
    }

    @PutMapping("/{id}")
    public ResponseBase actualizar(@PathVariable Long id,
                                   @RequestBody RequestEmpresa requestEmpresa) {
        return empresaServiceIn.actualizarIn(id, requestEmpresa);
    }

    @DeleteMapping("/{id}")
    public ResponseBase eliminar(@PathVariable Long id) {
        return empresaServiceIn.deleteIn(id);
    }
}
