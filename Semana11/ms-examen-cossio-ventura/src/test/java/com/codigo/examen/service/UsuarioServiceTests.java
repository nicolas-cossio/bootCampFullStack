package com.codigo.examen.service;

import com.codigo.examen.entity.Usuario;
import com.codigo.examen.repository.RolRepository;
import com.codigo.examen.repository.UsuarioRepository;
import com.codigo.examen.request.SignUpRequest;
import com.codigo.examen.service.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioServiceTests {
    @Mock
    private  UsuarioRepository usuarioRepository;
    @Mock
    private  RolRepository rolRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createUsuario_WhenUsernameExists_ReturnsBadRequest() {
        // Arrange
        SignUpRequest signUpRequest = new SignUpRequest("existingUsername", "test@example.com",
                "123456", "123456", List.of(1L));

        // Act
        when(usuarioRepository.findByUsername(signUpRequest.getUsername())).thenReturn(Optional.of(new Usuario()));
        ResponseEntity<Usuario> response = usuarioService.createUsuario(signUpRequest);

        // Assert
        assertEquals(ResponseEntity.badRequest().body(null), response);
    }

    @Test
    void createUsuario_WhenUsernameDoesNotExist_ReturnsOk() {
        // Arrange
        SignUpRequest signUpRequest = new SignUpRequest("joanPrad",  "joanPrad@gmail.com",
                "999123456", "123", List.of(1L, 2L));
        Usuario newUsuario = new Usuario();
        // Act
        when(usuarioRepository.findByUsername(anyString())).thenReturn(Optional.empty());
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(newUsuario);
        ResponseEntity<Usuario> response = usuarioService.createUsuario(signUpRequest);

        // Assert
        assertEquals(ResponseEntity.ok(newUsuario), response);
    }

    @Test
    void getUsuarioById_WhenUsuarioExists_ReturnsUsuario() {
        // Arrange
        Long id = 1L;
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(id);

        // Act
        when(usuarioRepository.findById(id)).thenReturn(Optional.of(usuario));
        ResponseEntity<Usuario> response = usuarioService.getUsuarioById(id);

        // Assert
        assertEquals(ResponseEntity.ok(usuario), response);
    }

    @Test
    void getUsuarioById_WhenUsuarioDoesNotExist_ReturnsNotFound() {
        // Arrange
        Long id = 1L;

        // Act
        when(usuarioRepository.findById(id)).thenReturn(Optional.empty());
        ResponseEntity<Usuario> response = usuarioService.getUsuarioById(id);

        // Assert
        assertEquals(ResponseEntity.notFound().build(), response);
    }

    @Test
    void deleteUsuario_WhenUsuarioExists_ReturnsNoContent() {
        // Arrange
        Long id = 1L;
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(id);

        // Act
        when(usuarioRepository.findById(id)).thenReturn(Optional.of(usuario));
        ResponseEntity<Usuario> response = usuarioService.deleteUsuario(id);

        // Assert
        assertEquals(ResponseEntity.noContent().build(), response);
    }

    @Test
    void deleteUsuario_WhenUsuarioDoesNotExist_ReturnsNotFound() {
        // Arrange
        Long id = 1L;

        // Act
        when(usuarioRepository.findById(id)).thenReturn(Optional.empty());
        ResponseEntity<Usuario> response = usuarioService.deleteUsuario(id);

        // Assert
        assertEquals(ResponseEntity.notFound().build(), response);
    }

}
