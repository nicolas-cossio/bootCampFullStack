package com.example.examenSpring.service;

import com.example.examenSpring.model.Pasajero;
import com.example.examenSpring.repository.PasajeroRepository;
import com.example.examenSpring.response.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PasajeroService {
    @Autowired
    private PasajeroRepository pasajeroRepository;

    public ResponseBase savePasajero(Pasajero pasajero) {
        // Validacion que no exista un pasajero con un mismo dni.
        Optional<Pasajero> pasajeroBd = pasajeroRepository.findByDni(pasajero.getDni());
        if (pasajeroBd.isPresent()) {
            return new ResponseBase(400,
                    "El pasajero ya existe en base de datos.",
                    false,
                    Optional.empty());
        }
        // Se valida que el dni tenga 8 digitos.
        if (pasajero.getDni().length() != 8) {
            return new ResponseBase(400,
                    "El dni debe tener 8 digitos.",
                    false,
                    Optional.empty());
        } else {
            Pasajero pasajeroNew = pasajeroRepository.save(pasajero);
            return new ResponseBase(200,
                    "Pasajero guardado con exito.",
                    false,
                    Optional.of(pasajeroNew));
        }
    }

    public ResponseBase findPasajeroById(Integer id ){
        // Se busca el vuelo por id.
        Optional<Pasajero> pasajeroBd = pasajeroRepository.findById(id);
        if (pasajeroBd.isPresent()) {
            return new ResponseBase(200,
                    "Pasajero encontrado.",
                    true,
                    Optional.of(pasajeroBd));
        } else {
            return new ResponseBase(400,
                    "El pasajero no existe en base de datos.",
                    false,
                    Optional.empty());
        }
    }
}
