package com.codigo.msregistro.infrastructure.mapper;

import com.codigo.msregistro.domain.aggregates.dto.PersonaDto;
import com.codigo.msregistro.infrastructure.entity.PersonaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PersonaMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public PersonaDto mapToDto(PersonaEntity entity) {
        return modelMapper.map(entity, PersonaDto.class);
    }

    public PersonaEntity mapToEntity(PersonaDto dto) {
        return modelMapper.map(dto, PersonaEntity.class);
    }
}
