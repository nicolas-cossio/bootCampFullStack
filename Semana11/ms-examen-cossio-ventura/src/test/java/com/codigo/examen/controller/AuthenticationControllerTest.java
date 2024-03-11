package com.codigo.examen.controller;

import com.codigo.examen.entity.Usuario;
import com.codigo.examen.request.SignInRequest;
import com.codigo.examen.request.SignUpRequest;
import com.codigo.examen.response.AuthenticationResponse;
import com.codigo.examen.service.AuthenticationService;
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

class AuthenticationControllerTest {
    @Mock
    private AuthenticationService authenticationService;
    @Mock
    private UsuarioService usuarioService;
    @InjectMocks
    private AuthenticationController authenticationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createUsuario_WhenSignUpRequestIsValid_ReturnsCreated() {
        // Arrange
        SignUpRequest signUpRequest = new SignUpRequest("username",  "test@example.com",
                "123456", "password", List.of(1L));
        Usuario usuario = new Usuario();

        // Act
        when(usuarioService.createUsuario(signUpRequest)).thenReturn(ResponseEntity.ok(usuario));
        ResponseEntity<Usuario> response = authenticationController.createUsuario(signUpRequest);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usuario, response.getBody());
    }

    @Test
    void createUsuario_WhenSignUpFails_ReturnsBadRequest() {
        // Arrange
        SignUpRequest signUpRequest = new SignUpRequest("username",  "test@example.com",
                "123456", "password", List.of(1L));

        // Act
        when(usuarioService.createUsuario(signUpRequest)).thenReturn(ResponseEntity.badRequest().body(null));
        ResponseEntity<Usuario> response = authenticationController.createUsuario(signUpRequest);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void signIn_WhenSignInRequestIsValid_ReturnsOkWithAuthenticationResponse() {
        // Arrange
        SignInRequest signInRequest = new SignInRequest("username", "password");
        AuthenticationResponse authenticationResponse = new AuthenticationResponse("token");

        // Act
        when(authenticationService.signIn(signInRequest)).thenReturn(authenticationResponse);
        ResponseEntity<AuthenticationResponse> response = authenticationController.signIn(signInRequest);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(authenticationResponse, response.getBody());
    }

}
