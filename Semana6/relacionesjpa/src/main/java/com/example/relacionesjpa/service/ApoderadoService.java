package com.example.relacionesjpa.service;

import com.example.relacionesjpa.model.Apoderado;
import com.example.relacionesjpa.repository.ApoderadoRepository;
import com.example.relacionesjpa.response.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ApoderadoService {
    @Autowired
    private ApoderadoRepository apoderadoRepository;

    public ResponseBase saveApoderado(Apoderado apoderado) {
        // Verificar que el apoderado no exista
        Optional<Apoderado> apoderadoBD = apoderadoRepository.findByEmail(apoderado.getEmail());
        if(apoderadoBD.isPresent()) {
            return new ResponseBase(400,
                    "Apoderado con el email " + apoderado.getEmail() + " ya existe",
                    false,
                    Optional.empty());
        }
        apoderado.setRole("Apoderado");
        apoderado.setFechaCreacion(new Date());
        apoderadoRepository.save(apoderado);
        return new ResponseBase(201,
                "Apoderado creado",
                true,
                Optional.of(apoderado));
    }

    public ResponseBase findById(Integer id) {
        //Buscar el apoderado por id
        Optional<Apoderado> apoderadoBD = apoderadoRepository.findById(id);
        if(apoderadoBD.isPresent()) {
            return new ResponseBase(201,
                    "Success",
                    true,
                    apoderadoBD);
        }
        else {
            return new ResponseBase(404,
                    "Apoderado no encontrado",
                    false,
                    Optional.empty());
        }
    }

}
