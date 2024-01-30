package com.example.springBasico.controller;

import com.example.springBasico.entity.Usuario;
import com.example.springBasico.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {
    UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("usuario/{id}")
    public ResponseEntity<?> buscarUsuarioId(@PathVariable Integer id) {
        try {
            Optional<Usuario> usuarioOpt = usuarioService.buscarById(id);
            if(usuarioOpt.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
            }
            else {
                return ResponseEntity.ok(usuarioOpt.get());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("usuario/new")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioNew = new Usuario();
        try {
            usuarioNew = usuarioService.crearUsuario(usuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usuarioNew;
    }

    @GetMapping("usuario/list")
    public ResponseEntity<?> mostrarUsuarios() {
        try {
            List<Usuario> usuarios = usuarioService.findAll();
            if (usuarios.size() > 0) {
                return ResponseEntity.ok(usuarios);
            }
            else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No existen usuarios");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }

    @PutMapping("usuario/{id}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Optional<Usuario> user = usuarioService.updateById(id, usuario);
        if(user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario a actualizar no existe.");
        }
    }
}
