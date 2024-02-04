package com.example.springSabado.controller;


import com.example.springSabado.model.Libro;
import com.example.springSabado.response.ResponseBase;
import com.example.springSabado.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/libro")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @PostMapping("/save")
    public ResponseBase crear(@RequestBody Libro libro) {
        return libroService.crearLibro(libro);
    }

    @PatchMapping("/agregarAutor")
    public ResponseBase agregarAutor(@RequestBody Map<String, Integer> request) {
        return libroService.agregarAutor(request);
    }

    @GetMapping("/{id}")
    public ResponseBase buscarPorId(@PathVariable Integer id) {
        return libroService.buscarPorId(id);
    }
}