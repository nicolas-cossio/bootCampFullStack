package com.example.springSabado.service;

import com.example.springSabado.model.Prestamo;
import com.example.springSabado.repository.LibroRepository;
import com.example.springSabado.repository.PrestamoRepository;
import com.example.springSabado.repository.UsuarioRepository;
import com.example.springSabado.response.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrestamoService {
    @Autowired
    private PrestamoRepository prestamoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private LibroRepository libroRepository;

    public ResponseBase registrarPrestamo(Prestamo prestamo) {
        Integer usuarioId = prestamo.getPrestamoId().getUsuarioId();
        Integer libroId = prestamo.getPrestamoId().getLibroId();

        if (usuarioRepository.existsById(usuarioId) && libroRepository.existsById(libroId)) {
            Prestamo prestamoNew =  prestamoRepository.save(prestamo);
            return new ResponseBase(200,
                    "Prestamo registrado con exito.",
                    true,
                    Optional.of(prestamoNew));
        } else {
            return new ResponseBase(400,
                    "No se pudo registrar el prestamo",
                    false,
                    Optional.empty());
        }
    }


}
