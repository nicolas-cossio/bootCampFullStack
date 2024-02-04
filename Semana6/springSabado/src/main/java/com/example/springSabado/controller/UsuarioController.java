package com.example.springSabado.controller;

import com.example.springSabado.model.Usuario;
import com.example.springSabado.response.ResponseBase;
import com.example.springSabado.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/save")
    public ResponseBase crear(@RequestBody Usuario usuario) {
        return usuarioService.agregarUsuario(usuario);
    }

}
