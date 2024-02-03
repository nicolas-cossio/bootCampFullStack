package com.example.refuerzoJueves.service;

import com.example.refuerzoJueves.model.Autor;
import com.example.refuerzoJueves.model.Libro;
import com.example.refuerzoJueves.repository.AutorRepository;
import com.example.refuerzoJueves.response.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public ResponseBase agregarAutor(Autor autor) {
        // Se verifica que el autor no exista.
        Optional<Autor> autorBd = autorRepository.findByDni(autor.getDni());
        if (autorBd.isPresent()) {
            return new ResponseBase(400,
                    "El autor con dni " + autor.getDni() + " ya existe.",
                    false,
                    Optional.empty());
        } else {
            // Se verifica que el dni tenga 8 caracteres y el correo tenga @
            if (autor.getDni().length() != 8) {
                return new ResponseBase(400,
                        "El dni debe tener 8 caracteres",
                        false,
                        Optional.empty());
            }
            if (!autor.getCorreo().contains("@")) {
                return new ResponseBase(400,
                        "El correo debe tener @",
                        false,
                        Optional.empty());
            }
            // Si cumple con las validaciones se guarda el autor.
            Autor autorSave = autorRepository.save(autor);
            return new ResponseBase(200,
                    "El autor se guardó correctamente",
                    true,
                    Optional.of(autorSave));
        }
    }

    public ResponseBase buscarById(Integer id) {
        Optional<Autor> autor = autorRepository.findById(id);
        if (autor.isPresent()) {
            return new ResponseBase(200,
                    "Autor encontrado",
                    true,
                    Optional.of(autor.get()));
        } else {
            return new ResponseBase(404,
                    "Autor no encontrado",
                    false,
                    Optional.empty());
        }
    }

    // Devuelve los libros en base el id del autor.
    public ResponseBase mostrarLibrosAutor(Integer id) {
        // Se valida que el autor exista en bd.
        Optional<Autor> autorBd = autorRepository.findById(id);
        if (autorBd.isPresent()) {
            List<Libro> libros = autorBd.get().getLibros();
            if (!libros.isEmpty()) {
                return new ResponseBase(200,
                        "Libros encontrados",
                        true,
                        Optional.of(libros));
            } else {
                return new ResponseBase(200,
                        "El autor no tiene libros registrados",
                        true,
                        Optional.empty());
            }
        } else {
            return new ResponseBase(400,
                    "Autor no encontrado",
                    false,
                    Optional.empty());
        }
    }

}
