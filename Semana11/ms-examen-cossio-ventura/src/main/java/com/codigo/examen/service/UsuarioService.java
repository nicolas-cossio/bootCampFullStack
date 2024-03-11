package com.codigo.examen.service;

import com.codigo.examen.entity.Usuario;
import com.codigo.examen.request.SignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioService {
    // Metodo encargado del registro de usuarios sin necesidad de autenticacion.
    ResponseEntity<Usuario> createUsuario(SignUpRequest signUpRequest);
    // Metodos encargados de la gestion de usuarios que si necesitan token.
    ResponseEntity<Usuario> getUsuarioById(Long id);
    ResponseEntity<Usuario> updateUsuario(Long id, Usuario usuario);
    ResponseEntity<Usuario> deleteUsuario(Long id);

    UserDetailsService userDetailsService();
}
