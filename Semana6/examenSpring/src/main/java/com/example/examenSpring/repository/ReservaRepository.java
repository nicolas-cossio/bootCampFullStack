package com.example.examenSpring.repository;

import com.example.examenSpring.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    Optional<Reserva> findByVueloIdAndPasajeroId(Integer idVuelo, Integer idPasajero);
}
