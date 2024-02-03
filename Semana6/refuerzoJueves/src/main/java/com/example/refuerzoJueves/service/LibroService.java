package com.example.refuerzoJueves.service;

import com.example.refuerzoJueves.model.Libro;
import com.example.refuerzoJueves.repository.LibroRepository;
import com.example.refuerzoJueves.response.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public ResponseBase saveLibro(Libro libro) {
        if (libro.getIsbn().isEmpty()) {
            return new ResponseBase(400,
                    "Debe enviar el codigo del libro",
                    false,
                    Optional.empty());
        }
        Optional<Libro> libroBd = libroRepository.findById(libro.getIsbn());
        if (libroBd.isPresent()) {
            return new ResponseBase(400,
                    "El libro con isbn " + libro.getIsbn() + " ya existe en la base de datos",
                    false,
                    Optional.empty());
        } else {
            // Se valida que el año de publicacion sea mayor a 0 y que el isbn tenga 13 caracteres.
            if (libro.getAnioPublicacion() <= 0) {
                return new ResponseBase(400,
                        "El año de publicación debe ser mayor a 0",
                        false,
                        Optional.empty());
            }
            if (libro.getIsbn().length() != 13) {
                return new ResponseBase(400,
                        "El isbn debe tener 13 caracteres",
                        false,
                        Optional.empty());
            }
            Libro libroSave = libroRepository.save(libro);
            return new ResponseBase(200,
                    "El libro se guardó correctamente",
                    true,
                    Optional.of(libroSave));
        }
    }
}
