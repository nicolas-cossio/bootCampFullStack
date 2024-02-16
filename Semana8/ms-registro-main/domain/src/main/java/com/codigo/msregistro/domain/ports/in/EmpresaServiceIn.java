package com.codigo.msregistro.domain.ports.in;

import com.codigo.msregistro.domain.aggregates.dto.EmpresaDto;
import com.codigo.msregistro.domain.aggregates.request.RequestEmpresa;
import com.codigo.msregistro.domain.aggregates.response.ResponseBase;

public interface EmpresaServiceIn {
    ResponseBase crearEmpresaIn(RequestEmpresa requestEmpresa);
    ResponseBase obtenerEmpresaIn(Long id);
    ResponseBase obtenerTodosIn();
    ResponseBase actualizarIn(Long id, RequestEmpresa requestEmpresa);
    ResponseBase deleteIn(Long id);
}
