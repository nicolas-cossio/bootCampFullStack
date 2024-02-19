package com.example.mscossioventura.infrastructure.adapters;

import com.example.mscossioventura.domain.aggregates.constants.Constants;
import com.example.mscossioventura.domain.aggregates.dto.PersonaDto;
import com.example.mscossioventura.domain.aggregates.request.RequestPersona;
import com.example.mscossioventura.domain.aggregates.response.ResponseBase;
import com.example.mscossioventura.domain.aggregates.response.ResponseReniec;
import com.example.mscossioventura.domain.ports.out.PersonaServiceOut;
import com.example.mscossioventura.infrastructure.entity.PersonaEntity;
import com.example.mscossioventura.infrastructure.entity.TipoDocumentoEntity;
import com.example.mscossioventura.infrastructure.entity.TipoPersonaEntity;
import com.example.mscossioventura.infrastructure.mapper.PersonaMapper;
import com.example.mscossioventura.infrastructure.repository.PersonaRepository;
import com.example.mscossioventura.infrastructure.repository.TipoDocumentoRepository;
import com.example.mscossioventura.infrastructure.repository.TipoPersonaRepository;
import com.example.mscossioventura.infrastructure.rest.client.ClientReniec;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonaAdapter implements PersonaServiceOut {

    private final PersonaRepository personaRepository;
    private final TipoPersonaRepository tipoPersonaRepository;
    private final TipoDocumentoRepository tipoDocumentoRepository;
    private final ClientReniec clientReniec;
    private final PersonaMapper personaMapper;

    @Override
    public ResponseBase crearPersonaOut(RequestPersona requestPersona) {
        ResponseReniec responseReniec = getExecutionReniec(requestPersona.getNumDoc());
        PersonaEntity personaEntity = getEntity(responseReniec, requestPersona);
        personaRepository.save(personaEntity);
        return new ResponseBase(Constants.CODE_OK,
                "Persona con numero de documento: "+personaEntity.getNumDocu()+
                        " fue registrado correctamente",
                Optional.of(personaMapper.mapToDto(personaEntity)));
    }

    // Se consulta la persona con estado ACTIVO
    @Override
    public ResponseBase consultaPersonaOut(String numDoc) {
        Optional<PersonaEntity> personaBd = personaRepository.findByNumDocuAndEstado(numDoc, 1);
        if (personaBd.isPresent()) {
            return new ResponseBase(Constants.CODE_OK,
                    "Persona encontrada correctamente.",
                    Optional.of(personaMapper.mapToDto(personaBd.get()))
            );
        }
        return new ResponseBase(Constants.CODE_ERROR,
                "No se encontró la persona con ese id",
                Optional.empty());
    }

    // Se consulta todas las personas con estado ACTIVO
    @Override
    public ResponseBase consultaPersonasOut() {
        List<PersonaEntity> personasBd = personaRepository.findAllByEstado(1);
        List<PersonaDto> personas = new ArrayList<>();
        for (PersonaEntity p : personasBd) {
            personas.add(personaMapper.mapToDto(p));
        }
        return new ResponseBase(Constants.CODE_OK,
                Constants.MESSAGE_OK,
                Optional.of(personas));
    }

    @Override
    public ResponseBase actualizarPersonaOut(Long id, RequestPersona requestPersona) {
        boolean exists = personaRepository.existsById(id);
        if (exists) {
            ResponseReniec datosReniec = getExecutionReniec(requestPersona.getNumDoc());
            PersonaEntity personaBd = personaRepository.findById(id).get();
            PersonaEntity personaUpdate = getEntityUpdate(datosReniec, personaBd);
            personaRepository.save(personaUpdate);
            return new ResponseBase(Constants.CODE_OK,
                    "Registro actualizado correctamente.",
                    Optional.of(personaMapper.mapToDto(getEntityUpdate(datosReniec, personaUpdate))));
        }
        return new ResponseBase(Constants.CODE_OK,
                "No se encontró la persona a actualizar",
                Optional.empty());
    }

    @Override
    public ResponseBase eliminarPersonaOut(Long id) {
        boolean exists = personaRepository.existsById(id);
        if (exists) {
            Optional<PersonaEntity> persona = personaRepository.findById(id);
            persona.get().setEstado(0);
            persona.get().setUsuaDelet(Constants.AUDIT_ADMIN);
            persona.get().setDateDelet(getTimestamp());
            personaRepository.save(persona.get());
            return new ResponseBase(Constants.CODE_OK,
                    Constants.MESSAGE_OK,
                    Optional.of(personaMapper.mapToDto(persona.get())));
        }
        return new ResponseBase(Constants.CODE_OK,
                "No se encontró la persona a actualizar",
                Optional.empty());
    }

    @Value("${token.api}")
    public String tokenApi;

    public ResponseReniec getExecutionReniec(String numero) {
        String auth = "Bearer " + tokenApi;
        return clientReniec.getInfo(numero, auth);
    }

    private PersonaEntity getEntity(ResponseReniec reniec, RequestPersona requestPersona) {
        TipoDocumentoEntity tipoDocumento = tipoDocumentoRepository.findByCodTipo(requestPersona.getTipoDoc());
        TipoPersonaEntity tipoPersona = tipoPersonaRepository.findByCodTipo(requestPersona.getTipoPer());
        PersonaEntity entity = new PersonaEntity();
        entity.setNumDocu(reniec.getNumeroDocumento());
        entity.setNombres(reniec.getNombres());
        entity.setApePat(reniec.getApellidoPaterno());
        entity.setApeMat(reniec.getApellidoMaterno());
        entity.setEstado(Constants.STATUS_ACTIVE);
        entity.setUsuaCrea(Constants.AUDIT_ADMIN);
        entity.setDateCreate(getTimestamp());
        entity.setTipoDocumento(tipoDocumento);
        entity.setTipoPersona(tipoPersona);
        return entity;
    }

    private PersonaEntity getEntityUpdate(ResponseReniec reniec, PersonaEntity personaActualizar) {
        personaActualizar.setNombres(reniec.getNombres());
        personaActualizar.setApePat(reniec.getApellidoPaterno());
        personaActualizar.setApeMat(reniec.getApellidoMaterno());
        personaActualizar.setUsuaModif(Constants.AUDIT_ADMIN);
        personaActualizar.setDateModif(getTimestamp());
        return personaActualizar;
    }

    private Timestamp getTimestamp() {
        long currentTime = System.currentTimeMillis();
        return new Timestamp(currentTime);
    }
}
