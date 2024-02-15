package com.codigo.msregistro.domain.ports.in;

import com.codigo.msregistro.domain.aggregates.dto.EmpresaDto;
import com.codigo.msregistro.domain.aggregates.request.RequestEmpresa;
import com.codigo.msregistro.domain.aggregates.response.ResponseBase;

import java.util.List;
import java.util.Optional;

public interface EmpresaServiceIn {
    ResponseBase crearEmpresaIn(RequestEmpresa requestEmpresa);
    Optional<EmpresaDto> obtenerEmpresaIn(Long id);
    List<EmpresaDto> obtenerTodosIn();
    EmpresaDto actualizarIn(Long id, RequestEmpresa requestEmpresa);
    EmpresaDto deleteIn(Long id);
}
