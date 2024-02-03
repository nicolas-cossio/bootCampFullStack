package com.example.examenSpring.repository;

import com.example.examenSpring.model.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotoRepository extends JpaRepository<Piloto,Integer> {
}
