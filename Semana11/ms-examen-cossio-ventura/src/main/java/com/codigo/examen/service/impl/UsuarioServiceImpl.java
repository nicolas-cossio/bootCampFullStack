package com.codigo.examen.service.impl;

import com.codigo.examen.entity.Rol;
import com.codigo.examen.entity.Usuario;
import com.codigo.examen.repository.RolRepository;
import com.codigo.examen.repository.UsuarioRepository;
import com.codigo.examen.request.SignUpRequest;
import com.codigo.examen.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    @Override
    public ResponseEntity<Usuario> createUsuario(SignUpRequest signUpRequest) {
        Optional<Usuario> existingUser = usuarioRepository.findByUsername(signUpRequest.getUsername());
        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().body(null);
        } else {
            Usuario usuario = new Usuario();
            usuario.setUsername(signUpRequest.getUsername());
            usuario.setTelefono(signUpRequest.getTelefono());
            usuario.setEmail(signUpRequest.getEmail());
            usuario.setPassword(new BCryptPasswordEncoder().encode(signUpRequest.getPassword()));
//             Asignamos los roles
            Set<Rol> roles = new HashSet<>();
            for (Long idR : signUpRequest.getRoles()) {
                Optional<Rol> rol = rolRepository.findById(idR);
                if (rol.isPresent()) roles.add(rol.get());
            }
            usuario.setRoles(roles);
            Usuario newUsuario = usuarioRepository.save(usuario);
            return ResponseEntity.ok(newUsuario);
        }
    }

    @Override
    public ResponseEntity<Usuario> getUsuarioById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Usuario> updateUsuario(Long id, Usuario usuario) {
        Optional<Usuario> existingUsuario = usuarioRepository.findById(id);
        if (existingUsuario.isPresent()) {
            usuario.setIdUsuario(id);

            if (!usuario.getUsername().equals(existingUsuario.get().getUsername())) {
                Optional<Usuario> userWithNewUsername = usuarioRepository.findByUsername(usuario.getUsername());
                if (userWithNewUsername.isPresent()) {
                    return ResponseEntity.badRequest().body(null);
                }
            }
            return getUsuarioResponseEntity(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private ResponseEntity<Usuario> getUsuarioResponseEntity(Usuario usuario) {
        Set<Rol> assignedRoles = new HashSet<>();
        for (Rol roles : usuario.getRoles()) {
            Optional<Rol> rol = rolRepository.findById(roles.getIdRol());
            if (rol.isEmpty()) {
                return ResponseEntity.badRequest().body(null);
            }
            assignedRoles.add(rol.get());
        }
        usuario.setRoles(assignedRoles);
        Usuario updatedUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(updatedUsuario);
    }

    @Override
    public ResponseEntity<Usuario> deleteUsuario(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.delete(usuario.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Metodo necesario para requerimiento de seguridad
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return usuarioRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                        "Username not found"));
            }
        };
    }
}
