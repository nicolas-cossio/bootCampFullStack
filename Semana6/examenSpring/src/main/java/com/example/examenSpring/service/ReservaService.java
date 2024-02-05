package com.example.examenSpring.service;

import com.example.examenSpring.model.Pasajero;
import com.example.examenSpring.model.Reserva;
import com.example.examenSpring.repository.PasajeroRepository;
import com.example.examenSpring.repository.ReservaRepository;
import com.example.examenSpring.response.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private PasajeroRepository pasajeroRepository;

    public ResponseBase saveReserva(Reserva reserva) {
        // Un pasajero solo puede estar en un vuelo a la vez
        Optional<Reserva> reservaBd = reservaRepository.findByVueloIdAndPasajeroId(
                reserva.getVuelo().getId(), reserva.getPasajero().getId());
        if (reservaBd.isPresent()) {
            return new ResponseBase(400,
                    "El pasajero con dni: "+reserva.getPasajero().getDni()+" ya tiene una " +
                            "reserva registrada en ese vuelo.",
                    false,
                    Optional.empty());
        } else {
            // Cuando se crea una reserva se debe crear un codigo de reserva único.
            Optional<Pasajero> pasajeroBd = pasajeroRepository.findById(reserva.getPasajero().getId());
            if (pasajeroBd.isPresent()) {
                String codReserva = "RES"+pasajeroBd.get().getDni()+"-"+reserva.getVuelo().getId();
                reserva.setCodigoReserva(codReserva);
                // Se crea la reserva.
                Reserva reservaNew = reservaRepository.save(reserva);
                return new ResponseBase(200,
                        "Reserva registrada correctamente.",
                        true,
                        Optional.of(reservaNew));
            }
            else {
                return new ResponseBase(400,
                        "No se pudo registrar la reserva, pasajero no encontrado.",
                        false,
                        Optional.empty());
            }
        }
    }

    public ResponseBase getReservaById(Integer id) {
        // Se busca el vuelo por id.
        Optional<Reserva> reservaBd = reservaRepository.findById(id);
        if (reservaBd.isPresent()) {
            return new ResponseBase(200,
                    "Reserva encontrado.",
                    true,
                    Optional.of(reservaBd));
        } else {
            return new ResponseBase(400,
                    "La reserva no existe en base de datos.",
                    false,
                    Optional.empty());
        }
    }
}
