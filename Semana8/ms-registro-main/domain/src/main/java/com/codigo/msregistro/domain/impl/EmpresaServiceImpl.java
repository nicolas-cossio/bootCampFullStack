package com.codigo.msregistro.domain.impl;

import com.codigo.msregistro.domain.aggregates.dto.EmpresaDto;
import com.codigo.msregistro.domain.aggregates.request.RequestEmpresa;
import com.codigo.msregistro.domain.aggregates.response.ResponseBase;
import com.codigo.msregistro.domain.ports.in.EmpresaServiceIn;
import com.codigo.msregistro.domain.ports.out.EmpresaServiceOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaServiceIn {
    private final EmpresaServiceOut empresaServiceOut;

    @Override
    public ResponseBase crearEmpresaIn(RequestEmpresa requestEmpresa) {
        return empresaServiceOut.crearEmpresaOut(requestEmpresa);
    }

    @Override
    public ResponseBase obtenerEmpresaIn(Long id) {
        return empresaServiceOut.obtenerEmpresaOut(id);
    }

    @Override
    public ResponseBase obtenerTodosIn() {
        return empresaServiceOut.obtenerTodosOut();
    }

    @Override
    public ResponseBase actualizarIn(Long id, RequestEmpresa requestEmpresa) {
        return empresaServiceOut.actualizarOut(id, requestEmpresa);
    }

    @Override
    public ResponseBase deleteIn(Long id) {
        return empresaServiceOut.deleteOut(id);
    }
}
