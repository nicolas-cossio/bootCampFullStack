package com.example.examenSpring.repository;

import com.example.examenSpring.model.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AerolineaRepository extends JpaRepository<Aerolinea, Integer> {
    Optional<Aerolinea> findByNombre(String nombre);
}
