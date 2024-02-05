package com.example.examenSpring.service;

import com.example.examenSpring.model.Avion;
import com.example.examenSpring.model.Vuelo;
import com.example.examenSpring.repository.VueloRepository;
import com.example.examenSpring.response.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VueloService {
    @Autowired
    private VueloRepository vueloRepository;

    public ResponseBase saveVuelo(Vuelo vuelo) {
        // Se valida que el vuelo no exista.
        Optional<Vuelo> vueloBd =
                vueloRepository.findByAvionIdAndFechaSalidaAndFechaLlegada(
                    vuelo.getId(), vuelo.getFechaSalida(), vuelo.getFechaLlegada());
        if(vueloBd.isPresent()) {
            return new ResponseBase(400,
                    "El vuelo ya existe en base de datos.",
                    false,
                    Optional.empty());
        } else {
            // Se valida que la fecha llegada sea mayor que fecha salida
            if (vuelo.getFechaLlegada().before(vuelo.getFechaSalida())) {
                return new ResponseBase(400,
                        "La fecha de llegada debe ser menor a la fecha de salida.",
                        false,
                        Optional.empty());
            }
            Vuelo vueloNew = vueloRepository.save(vuelo);
            return new ResponseBase(200,
                    "Vuelo guardado correctamente.",
                    true,
                    Optional.of(vueloNew));
        }
    }

    public ResponseBase getVueloById(Integer id) {
        // Se busca el vuelo por id.
        Optional<Vuelo> vueloBd = vueloRepository.findById(id);
        if (vueloBd.isPresent()) {
            return new ResponseBase(200,
                    "Vuelo encontrado.",
                    true,
                    Optional.of(vueloBd));
        } else {
            return new ResponseBase(400,
                    "El vuelo no existe en base de datos.",
                    false,
                    Optional.empty());
        }
    }
}
