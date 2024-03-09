package com.codigo.mslogin.config;

import com.codigo.mslogin.service.JWTService;
import com.codigo.mslogin.service.UsuarioService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class JwtAuthenticatonFilter extends OncePerRequestFilter {

    private final JWTService jwtService;
    private final UsuarioService usuarioService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Recupero la autorizacion
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;

        // Validacion 1: si está vacio o si no tiene token
        if (StringUtils.isEmpty(authHeader) || !StringUtils.startsWithIgnoreCase(authHeader, "Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        jwt = authHeader.substring(7);
        userEmail = jwtService.extractUserName(jwt);

        // Validacion 2: Email nulo y existe autenticacion?
        if (Objects.nonNull(userEmail) && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = usuarioService.userDetailsService().loadUserByUsername(userEmail);
            // Se valida el token que pertenezca a la persona en bd
            if (jwtService.validateToken(jwt, userDetails)) {
                // Se define un contexto vacio para más adelante setearle una autenticacion
                SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
                // Se autentica mediante el token y para eso necesita los datos de usuario, los roles
                UsernamePasswordAuthenticationToken authtoken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                // Permite crear una instancia de la clase para darnos los detalles adicionales para la solicitud.
                authtoken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                securityContext.setAuthentication(authtoken);
                // Aqui estan todas las autenticaciones.
                SecurityContextHolder.setContext(securityContext);
            }
        }
        // Si existe autenticacion es el mismo usuario que pide transaccion entonces debe seguir.
        filterChain.doFilter(request, response);
    }
}
