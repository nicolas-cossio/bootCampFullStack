package com.example.examenSpring.repository;

import com.example.examenSpring.model.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PilotoRepository extends JpaRepository<Piloto,Integer> {
    Optional<Piloto> findByMatricula(Integer matricula);
}
