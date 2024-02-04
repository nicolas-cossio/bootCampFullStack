package com.example.springSabado.controller;

import com.example.springSabado.model.Autor;
import com.example.springSabado.response.ResponseBase;
import com.example.springSabado.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/autor")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @PostMapping("/save")
    public ResponseBase crear(@RequestBody Autor autor) {
        return autorService.agregarAutor(autor);
    }

    @GetMapping("/{id}")
    public ResponseBase buscarPorId(@PathVariable Integer id) {
        return autorService.buscarPorId(id);
    }
}
