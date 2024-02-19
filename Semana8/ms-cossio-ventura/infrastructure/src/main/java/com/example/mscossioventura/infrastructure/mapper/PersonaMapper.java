package com.example.mscossioventura.infrastructure.mapper;

import com.example.mscossioventura.domain.aggregates.dto.PersonaDto;
import com.example.mscossioventura.infrastructure.entity.PersonaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonaMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public PersonaDto mapToDto(PersonaEntity entity) {
        return modelMapper.map(entity, PersonaDto.class);
    }

    public PersonaEntity mapToEntity(PersonaDto dto) {
        return modelMapper.map(dto, PersonaEntity.class);
    }
}
