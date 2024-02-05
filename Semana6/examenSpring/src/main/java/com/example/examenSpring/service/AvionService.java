package com.example.examenSpring.service;

import com.example.examenSpring.model.Aerolinea;
import com.example.examenSpring.model.Avion;
import com.example.examenSpring.repository.AvionRepository;
import com.example.examenSpring.response.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AvionService {
    @Autowired
    private AvionRepository avionRepository;

    public ResponseBase saveAvion(Avion avion) {
        // Se valida que el avión sea diferente por el numero de serie
        Optional<Avion> avionBd = avionRepository.findBySerie(avion.getSerie());
        if(avionBd.isPresent()) {
            return new ResponseBase(400,
                    "El avión ya existe en base de datos.",
                    false,
                    Optional.empty());
        } else {
            // Se valida que la capacidad de pasajeros sea mayor a 0.
            if (avion.getCapacidadPasajeros() < 0) {
                return new ResponseBase(400,
                        "El avión debe tener una capacidad mayor a  0.",
                        false,
                        Optional.empty());
            }
            Avion avionNew = avionRepository.save(avion);
            return new ResponseBase(200,
                    "Avión guardado correctamente.",
                    true,
                    Optional.of(avionNew));
        }
    }

    public ResponseBase findAvionById(Integer id) {
        // Se busca la aerolinea por id.
        Optional<Avion> avionBd = avionRepository.findById(id);
        if (avionBd.isPresent()) {
            return new ResponseBase(200,
                    "Avión encontrado.",
                    true,
                    Optional.of(avionBd));
        } else {
            return new ResponseBase(400,
                    "El avión no existe en base de datos.",
                    false,
                    Optional.empty());
        }
    }
}
