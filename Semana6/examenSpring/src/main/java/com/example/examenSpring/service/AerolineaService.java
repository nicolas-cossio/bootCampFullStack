package com.example.examenSpring.service;

import com.example.examenSpring.model.Aerolinea;
import com.example.examenSpring.repository.AerolineaRepository;
import com.example.examenSpring.response.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AerolineaService {
    @Autowired
    AerolineaRepository aerolineaRepository;

    public ResponseBase saveAerolinea(Aerolinea aerolinea) {
        // Se valida que el nombre de la aerolinea no exista.
        Optional<Aerolinea> aerolineaBd = aerolineaRepository.findByNombre(aerolinea.getNombre());
        if (aerolineaBd.isPresent()) {
            return new ResponseBase(400,
                    "La aerolinea ya existe en base de datos.",
                    false,
                    Optional.empty());
        } else {
            Aerolinea aerolineaSave = aerolineaRepository.save(aerolinea);
            return new ResponseBase(200,
                    "Aerolinea guardada correctamente.",
                    true,
                    Optional.of(aerolineaSave));
        }
    }

    public ResponseBase findById(Integer id) {
        // Se busca la aerolinea por id.
        Optional<Aerolinea> aerolineaBd = aerolineaRepository.findById(id);
        if (aerolineaBd.isPresent()) {
            return new ResponseBase(200,
                    "Aerolinea encontrada.",
                    true,
                    Optional.of(aerolineaBd));
        } else {
            return new ResponseBase(400,
                    "La aerolinea no existe en base de datos.",
                    false,
                    Optional.empty());
        }
    }
}
