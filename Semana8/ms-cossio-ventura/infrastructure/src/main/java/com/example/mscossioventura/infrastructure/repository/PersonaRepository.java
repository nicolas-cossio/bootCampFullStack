package com.example.mscossioventura.infrastructure.repository;

import com.example.mscossioventura.infrastructure.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {
    Optional<PersonaEntity> findByIdPersonaAndEstado(Long id, int valor);
    List<PersonaEntity> findAllByEstado(int valor);
    Optional<PersonaEntity> findByNumDocuAndEstado(String numDoc, int valor);
}
