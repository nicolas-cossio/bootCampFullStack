package com.example.springBasico.service;

import com.example.springBasico.entity.Usuario;
import com.example.springBasico.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario crearUsuario(Usuario usuario) {
        // Se valida que el usuario no exista.
//        user = usuarioRepository.findByNombre(usuario.getNombre());
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarById(Integer id) {
        Optional<Usuario> usuarioBD = usuarioRepository.findById(id);
        return usuarioBD;
    }

    public Optional<Usuario> updateById(Integer id, Usuario usuario) {
        Optional<Usuario> usuarioBD = usuarioRepository.findById(id);
        if (usuarioBD.isPresent()) {
            Usuario user = usuarioBD.get();
            user.setNombre(usuario.getNombre());
            user.setApellido(usuario.getApellido());
            return Optional.of(usuarioRepository.save(user));
        }
        return Optional.empty();
    }
}
