package com.codigo.examen.service;

import com.codigo.examen.entity.Usuario;
import com.codigo.examen.repository.UsuarioRepository;
import com.codigo.examen.request.SignInRequest;
import com.codigo.examen.response.AuthenticationResponse;
import com.codigo.examen.service.impl.AuthenticationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class AuthenticationServiceTest {
    @Mock
    private UsuarioRepository usuarioRepository;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private JWTService jwtService;
    @InjectMocks
    private AuthenticationServiceImpl authenticationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void signIn_WhenValidCredentials_ReturnsAuthenticationResponseWithToken() {
        // Arrange
        SignInRequest signInRequest = new SignInRequest("username", "password");
        Usuario usuario = new Usuario();
        usuario.setUsername(signInRequest.getUsername());
        usuario.setPassword(signInRequest.getPassword());

        // Act
        when(usuarioRepository.findByUsername(signInRequest.getUsername())).thenReturn(java.util.Optional.of(usuario));
        when(jwtService.generateToken(usuario)).thenReturn("generatedToken");
        AuthenticationResponse response = authenticationService.signIn(signInRequest);

        // Assert
        assertNotNull(response);
        assertEquals("generatedToken", response.getToken());
    }

    @Test
    void signIn_WhenInvalidCredentials_ThrowsIllegalArgumentException() {
        // Arrange
        SignInRequest signInRequest = new SignInRequest("nonExistentUsername", "password");

        // Act
        when(usuarioRepository.findByUsername(signInRequest.getUsername())).thenReturn(java.util.Optional.empty());

        // Assert
        assertThrows(IllegalArgumentException.class, () -> authenticationService.signIn(signInRequest));
    }

}
