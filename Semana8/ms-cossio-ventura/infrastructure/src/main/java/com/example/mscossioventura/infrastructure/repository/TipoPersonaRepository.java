package com.example.mscossioventura.infrastructure.repository;

import com.example.mscossioventura.infrastructure.entity.TipoPersonaEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoPersonaRepository extends JpaRepository<TipoPersonaEntity, Long> {
    TipoPersonaEntity findByCodTipo(@Param("codTipo") String codTipo);

}
