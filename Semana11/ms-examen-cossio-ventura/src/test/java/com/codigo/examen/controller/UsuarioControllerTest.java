package com.codigo.examen.controller;

import com.codigo.examen.entity.Usuario;
import com.codigo.examen.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UsuarioControllerTest {
    @Mock
    private UsuarioService usuarioService;
    @InjectMocks
    private UsuarioController usuarioController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getUsuarioById_WhenValidId_ReturnsOkWithUsuario() {
        // Arrange
        Long userId = 1L;
        Usuario usuario = new Usuario();

        // Act
        when(usuarioService.getUsuarioById(userId)).thenReturn(ResponseEntity.ok(usuario));
        ResponseEntity<Usuario> response = usuarioController.getUsuarioById(userId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usuario, response.getBody());
    }

    @Test
    void getUsuarioById_WhenInvalidId_ReturnsNotFound() {
        // Arrange
        Long userId = 1L;

        // Act
        when(usuarioService.getUsuarioById(userId)).thenReturn(ResponseEntity.notFound().build());
        ResponseEntity<Usuario> response = usuarioController.getUsuarioById(userId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void updateUsuario_WhenValidIdAndUsuario_ReturnsOkWithUpdatedUsuario() {
        // Arrange
        Long userId = 1L;
        Usuario usuario = new Usuario();

        // Act
        when(usuarioService.updateUsuario(userId, usuario)).thenReturn(ResponseEntity.ok(usuario));
        ResponseEntity<Usuario> response = usuarioController.updateUsuario(userId, usuario);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usuario, response.getBody());
    }

    @Test
    void updateUsuario_WhenInvalidId_ReturnsNotFound() {
        // Arrange
        Long userId = 1L;
        Usuario usuario = new Usuario();

        // Act
        when(usuarioService.updateUsuario(userId, usuario)).thenReturn(ResponseEntity.notFound().build());
        ResponseEntity<Usuario> response = usuarioController.updateUsuario(userId, usuario);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void deleteUsuario_WhenValidId_ReturnsNoContent() {
        // Arrange
        Long userId = 1L;

        // Act
        when(usuarioService.deleteUsuario(userId)).thenReturn(ResponseEntity.noContent().build());
        ResponseEntity<?> response = usuarioController.deleteUsuario(userId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void deleteUsuario_WhenInvalidId_ReturnsNotFound() {
        // Arrange
        Long userId = 1L;

        // Act
        when(usuarioService.deleteUsuario(userId)).thenReturn(ResponseEntity.notFound().build());
        ResponseEntity<?> response = usuarioController.deleteUsuario(userId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

}
