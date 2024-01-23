package com.example.springBasico.controller;

import com.example.springBasico.entity.Usuario;
import com.example.springBasico.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios")
    public List<Usuario> mostrarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            usuarios = usuarioService.mostrarUsuarios();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usuarios;
    }

    @PostMapping("/save")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioNew = new Usuario();
        try {
            usuarioNew = usuarioService.crearUsuario(usuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usuarioNew;
    }
}
