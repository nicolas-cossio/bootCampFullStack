package com.codigo.msregistro.infrastructure.mapper;

import com.codigo.msregistro.domain.aggregates.dto.EmpresaDto;
import com.codigo.msregistro.infrastructure.entity.EmpresaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class EmpresaMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public EmpresaDto mapToDto(EmpresaEntity entity) {
        return modelMapper.map(entity, EmpresaDto.class);
    }

    public EmpresaEntity mapToEntity(EmpresaDto dto) {
        return modelMapper.map(dto, EmpresaEntity.class);
    }
}
