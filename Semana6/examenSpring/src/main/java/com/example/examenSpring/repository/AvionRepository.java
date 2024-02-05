package com.example.examenSpring.repository;

import com.example.examenSpring.model.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Integer> {
    Optional<Avion> findBySerie(String serie);
}
