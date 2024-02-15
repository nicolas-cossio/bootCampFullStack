package com.codigo.msregistro.infrastructure.adapters;

import com.codigo.msregistro.domain.aggregates.constants.Constants;
import com.codigo.msregistro.domain.aggregates.dto.EmpresaDto;
import com.codigo.msregistro.domain.aggregates.request.RequestEmpresa;
import com.codigo.msregistro.domain.aggregates.response.ResponseBase;
import com.codigo.msregistro.domain.aggregates.response.ResponseSunat;
import com.codigo.msregistro.domain.ports.out.EmpresaServiceOut;
import com.codigo.msregistro.infrastructure.entity.EmpresaEntity;
import com.codigo.msregistro.infrastructure.entity.TipoDocumentoEntity;
import com.codigo.msregistro.infrastructure.mapper.EmpresaMapper;
import com.codigo.msregistro.infrastructure.repository.EmpresaRepository;
import com.codigo.msregistro.infrastructure.repository.TipoDocumentoRepository;
import com.codigo.msregistro.infrastructure.rest.client.ClientSunat;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaAdapter implements EmpresaServiceOut {

    private final EmpresaRepository empresaRepository;
    private final TipoDocumentoRepository tipoDocumentoRepository;
    private final EmpresaMapper empresaMapper;
    private final ClientSunat sunat;

    @Override
    public ResponseBase crearEmpresaOut(RequestEmpresa requestEmpresa) {
        try {
            ResponseSunat datosSunat = getExecutionSunat(requestEmpresa.getNumDoc());
            empresaRepository.save(getEntity(datosSunat, requestEmpresa));
            return new ResponseBase(Constants.CODE_OK,
                    Constants.MESSAGE_OK,
                    Optional.of(empresaMapper.mapToDto(getEntity(datosSunat, requestEmpresa)))
            );
        } catch (Exception e) {
            return new ResponseBase(Constants.CODE_ERROR,
                    e.getMessage(),
                    Optional.empty());
        }
    }

    @Override
    public Optional<EmpresaDto> obtenerEmpresaOut(Long id) {
        return Optional.ofNullable(empresaMapper.mapToDto(empresaRepository.findById(id).get()));
    }

    @Override
    public List<EmpresaDto> obtenerTodosOut() {
        return null;
    }

    @Override
    public EmpresaDto actualizarOut(Long id, RequestEmpresa requestEmpresa) {
        return null;
    }

    @Override
    public EmpresaDto deleteOut(Long id) {
        return null;
    }

    @Value("${token.api}")
    public String tokenApi;

    public ResponseSunat getExecutionSunat(String ruc) {
        String token = "Bearer " + tokenApi;
        return sunat.getInfo(ruc, token);
    }

    private EmpresaEntity getEntity(ResponseSunat responseSunat, RequestEmpresa requestEmpresa) {
        TipoDocumentoEntity tipoDocumento = tipoDocumentoRepository.findByCodTipo(requestEmpresa.getTipoDoc());
        EmpresaEntity empresaEntity = new EmpresaEntity();
        empresaEntity.setNumDocu(responseSunat.getNumeroDocumento());
        empresaEntity.setTipoDocumento(tipoDocumento);
        empresaEntity.setRazonSocial(responseSunat.getRazonSocial());
        empresaEntity.setNomComercial(responseSunat.getRazonSocial());
        empresaEntity.setEstado(Constants.STATUS_ACTIVE);
        empresaEntity.setUsuaCrea(Constants.AUDIT_ADMIN);
        empresaEntity.setDateCreate(getTimestamp());
        return empresaEntity;
    }

    private EmpresaEntity getEntityUpdate(ResponseSunat responseSunat, EmpresaEntity empresaActualizar) {
        empresaActualizar.setRazonSocial(responseSunat.getRazonSocial());
        empresaActualizar.setNomComercial(responseSunat.getRazonSocial());
        empresaActualizar.setUsuaModif(Constants.AUDIT_ADMIN);
        empresaActualizar.setDateModif(getTimestamp());
        return empresaActualizar;
    }

    private Timestamp getTimestamp() {
        long currentTime = System.currentTimeMillis();
        return new Timestamp(currentTime);
    }
}
