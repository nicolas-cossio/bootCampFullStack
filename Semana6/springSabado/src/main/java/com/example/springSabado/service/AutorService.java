package com.example.springSabado.service;

import com.example.springSabado.model.Autor;
import com.example.springSabado.repository.AutorRepository;
import com.example.springSabado.response.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public ResponseBase agregarAutor(Autor autor) {
        // Busqueda en base de datos.
        if(autorRepository.existsByNombre(autor.getNombre())) {
            return new ResponseBase(400,
                    "El autor ya existe",
                    false,
                    Optional.empty());
        } else {
            Autor autorNew = autorRepository.save(autor);
            return new ResponseBase(200,
                    "Autor creado con exito",
                    true,
                    Optional.of(autorNew));
        }
    }

    public ResponseBase buscarPorId(Integer id) {
        Optional<Autor> autorBd = autorRepository.findById(id);
        if (autorBd.isPresent()) {
            return new ResponseBase(200,
                    "Autor encontrado",
                    true,
                    Optional.of(autorBd));
        } else {
            return new ResponseBase(400,
                    "El autor no existe en base de datos.",
                    false,
                    Optional.empty());
        }
    }
}
