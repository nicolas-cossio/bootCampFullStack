package com.example.examenSpring.service;

import com.example.examenSpring.model.Piloto;
import com.example.examenSpring.repository.PilotoRepository;
import com.example.examenSpring.response.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PilotoService {
    @Autowired
    private PilotoRepository pilotoRepository;

    public ResponseBase savePiloto(Piloto piloto) {
        // Se valida que el piloto no esté registrado por el numero de matricula único.
        Optional<Piloto> pilotoBd = pilotoRepository.findByMatricula(piloto.getMatricula());
        if (pilotoBd.isPresent()) {
            return new ResponseBase(400,
                    "El piloto ya existe en base de datos.",
                    false,
                    Optional.empty());
        }
        Piloto pilotoNew = pilotoRepository.save(piloto);
        return new ResponseBase(200,
                "Piloto guardado correctamente.",
                true,
                Optional.of(pilotoNew));
    }

    public ResponseBase getPilotoById(Integer id) {
        // Se busca el piloto por id.
        Optional<Piloto> pilotoBd = pilotoRepository.findById(id);
        if (pilotoBd.isPresent()) {
            return new ResponseBase(200,
                    "Piloto encontrado.",
                    true,
                    Optional.of(pilotoBd));
        } else {
            return new ResponseBase(400,
                    "El piloto no existe en base de datos.",
                    false,
                    Optional.empty());
        }
    }

}
