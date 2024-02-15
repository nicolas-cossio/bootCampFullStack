package com.codigo.msregistro.infrastructure.repository;

import com.codigo.msregistro.infrastructure.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {
}
