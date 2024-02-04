package com.example.springSabado.service;

import com.example.springSabado.model.Autor;
import com.example.springSabado.model.Usuario;
import com.example.springSabado.repository.UsuarioRepository;
import com.example.springSabado.response.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseBase agregarUsuario(Usuario usuario) {
        // Busqueda en base de datos.
        if(usuarioRepository.existsByNombre(usuario.getNombre())) {
            return new ResponseBase(400,
                    "El autor ya existe",
                    false,
                    Optional.empty());
        } else {
            Usuario usuarioNew = usuarioRepository.save(usuario);
            return new ResponseBase(200,
                    "Autor creado con exito",
                    true,
                    Optional.of(usuarioNew));
        }
    }
}
