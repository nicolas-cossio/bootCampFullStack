package com.example.examenSpring.repository;

import com.example.examenSpring.model.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero, Integer> {
    Optional<Pasajero> findByDni(String dni);
}
