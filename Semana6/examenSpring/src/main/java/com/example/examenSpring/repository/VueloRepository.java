package com.example.examenSpring.repository;

import com.example.examenSpring.model.Avion;
import com.example.examenSpring.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Integer> {
    Optional<Vuelo> findByAvionIdAndFechaSalidaAndFechaLlegada(Integer avion_id,
                                                           Date fechaSalida, Date fechaLlegada);
}
