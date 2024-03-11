package com.codigo.practicasonar.service.impl;

import com.codigo.practicasonar.entity.Usuario;
import com.codigo.practicasonar.repository.UsuarioRepository;
import com.codigo.practicasonar.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public ResponseEntity<Usuario> crearUsuario(Usuario usuario) {
        if (!usuarioRepository.existsByNumDocumento(usuario.getNumDocumento())) {
            usuarioRepository.save(usuario);
            Optional<Usuario> recuperarUsuario = usuarioRepository.findByNumDocumento(usuario.getNumDocumento());
            return new ResponseEntity<>(recuperarUsuario.get(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<Usuario> obtenerUsuario(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
