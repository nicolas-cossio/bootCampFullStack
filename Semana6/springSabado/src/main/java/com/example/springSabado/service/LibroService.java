package com.example.springSabado.service;

import com.example.springSabado.model.Autor;
import com.example.springSabado.model.Libro;
import com.example.springSabado.repository.AutorRepository;
import com.example.springSabado.repository.LibroRepository;
import com.example.springSabado.response.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private AutorRepository autorRepository;

    public ResponseBase crearLibro(Libro libro) {
        Libro libroSave = libroRepository.save(libro);
        return new ResponseBase(200,
                "Libro creado con exito.",
                true,
                Optional.of(libroSave));
    }

    public ResponseBase agregarAutor(Map<String, Integer> request) {
        // Buscar el libro
        Optional<Libro> libroBd = libroRepository.findById(request.get("idLibro"));
        Optional<Autor> autorBd = autorRepository.findById(request.get("idAutor"));

        // Si se encuentran los dos id
        if (libroBd.isPresent() && autorBd.isPresent()) {
            Libro libro = libroBd.get();
            Autor autor = autorBd.get();
            libro.getAutors().add(autor);
            libroRepository.save(libro);
            return new ResponseBase(201,
                    "Autor registrado al libro con exito.",
                    true,
                    Optional.of(libro));
        }
        else {
            return new ResponseBase(400,
                    "Autor o libro no encontrado en base de datos",
                    false,
                    Optional.empty());
        }
    }

    public ResponseBase buscarPorId(Integer id) {
        Optional<Libro> libroBd = libroRepository.findById(id);
        if (libroBd.isPresent()) {
            return new ResponseBase(200,
                    "Libro encontrado",
                    true,
                    Optional.of(libroBd));
        } else {
            return new ResponseBase(400,
                    "El libro no existe en base de datos.",
                    false,
                    Optional.empty());
        }
    }
}
