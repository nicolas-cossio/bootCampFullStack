package com.codigo.msregistro.infrastructure.adapters;

import com.codigo.msregistro.domain.aggregates.constants.Constants;
import com.codigo.msregistro.domain.aggregates.dto.PersonaDto;
import com.codigo.msregistro.domain.aggregates.request.RequestPersona;
import com.codigo.msregistro.domain.aggregates.response.ResponseReniec;
import com.codigo.msregistro.domain.ports.out.PersonaServiceOut;
import com.codigo.msregistro.infrastructure.entity.PersonaEntity;
import com.codigo.msregistro.infrastructure.entity.TipoDocumentoEntity;
import com.codigo.msregistro.infrastructure.mapper.PersonaMapper;
import com.codigo.msregistro.infrastructure.redis.RedisService;
import com.codigo.msregistro.infrastructure.repository.PersonaRepository;
import com.codigo.msregistro.infrastructure.repository.TipoDocumentoRepository;
import com.codigo.msregistro.infrastructure.rest.client.ClientReniec;
import com.codigo.msregistro.infrastructure.util.Util;
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
    private final TipoDocumentoRepository tipoDocumentoRepository;
    private final PersonaMapper personaMapper;
    private final ClientReniec reniec;
    private final RedisService redisService;

    @Override
    public PersonaDto crearPersonaOut(RequestPersona requestPersona) {
        ResponseReniec datosReniec = getExecutionReniec(requestPersona.getNumDoc());
        personaRepository.save(getEntity(datosReniec, requestPersona));
        return personaMapper.mapToDto(getEntity(datosReniec, requestPersona));
    }

    @Override
    public Optional<PersonaDto> obtenerPersonaOut(Long id) {
        // Se consulta a redis si existe un registro para esta persona
        String redisInfo = redisService.getFromRedis(Constants.REDIS_KEY_PERSONA+id);
        if (redisInfo != null) {
            PersonaDto personaDto = Util.convertFromJson(redisInfo, PersonaDto.class);
            return Optional.of(personaDto);
        }
        else {
            PersonaDto dto = personaMapper.mapToDto(personaRepository.findById(id).get());
            String redis = Util.convertToJson(dto);
            redisService.saveInRedis(Constants.REDIS_KEY_PERSONA+id, redis, 1);
            return Optional.of(dto);
        }
    }

    @Override
    public List<PersonaDto> obtenerTodosOut() {
        List<PersonaDto> personas = new ArrayList<>();
        List<PersonaEntity> entities = personaRepository.findAll();
        entities.forEach(persona -> personas.add(personaMapper.mapToDto(persona)));
        return personas;
    }

    @Override
    public PersonaDto actualizarOut(Long id, RequestPersona requestPersona) {
        boolean exists = personaRepository.existsById(id);
        if (exists) {
            ResponseReniec datosReniec = getExecutionReniec(requestPersona.getNumDoc());
            PersonaEntity personaActualizar = personaRepository.findById(id).get();
            personaRepository.save(getEntityUpdate(datosReniec, personaActualizar));
            return personaMapper.mapToDto(getEntityUpdate(datosReniec, personaActualizar));
        }
        return null;
    }

    @Override
    public PersonaDto deleteOut(Long id) {
        boolean exists = personaRepository.existsById(id);
        if (exists) {
            Optional<PersonaEntity> persona = personaRepository.findById(id);
            persona.get().setEstado(0);
            persona.get().setUsuaDelet(Constants.AUDIT_ADMIN);
            persona.get().setDateDelet(getTimestamp());
            personaRepository.save(persona.get());
            return personaMapper.mapToDto(persona.get());
        }
        return null;
    }

    @Value("${token.api}")
    public String tokenApi;

    public ResponseReniec getExecutionReniec(String numero) {
        String auth = "Bearer " + tokenApi;
        return reniec.getInfo(numero, auth);
    }

    private PersonaEntity getEntity(ResponseReniec reniec, RequestPersona requestPersona) {
        TipoDocumentoEntity tipoDocumento = tipoDocumentoRepository.findByCodTipo(requestPersona.getTipoDoc());
        PersonaEntity entity = new PersonaEntity();
        entity.setNumDocu(reniec.getNumeroDocumento());
        entity.setNombres(reniec.getNombres());
        entity.setApePat(reniec.getApellidoPaterno());
        entity.setApeMat(reniec.getApellidoMaterno());
        entity.setEstado(Constants.STATUS_ACTIVE);
        entity.setUsuaCrea(Constants.AUDIT_ADMIN);
        entity.setDateCreate(getTimestamp());
        entity.setTipoDocumento(tipoDocumento);
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
