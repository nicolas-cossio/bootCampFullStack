package com.example.springBasico.service;

import com.example.springBasico.entity.Usuario;
import com.example.springBasico.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> mostrarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario crearUsuario(Usuario usuario) {
        // Se valida que el usuario no exista.
//        user = usuarioRepository.findByNombre(usuario.getNombre());
        return usuarioRepository.save(usuario);
    }
}
