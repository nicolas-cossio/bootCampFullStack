package com.example.refuerzoJueves.controller;

import com.example.refuerzoJueves.model.Libro;
import com.example.refuerzoJueves.response.ResponseBase;
import com.example.refuerzoJueves.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/libro")
public class LibroController {
    @Autowired
    LibroService libroService;

    @PostMapping("/save")
    public ResponseBase crearLibro(@RequestBody Libro libro) {
        return libroService.saveLibro(libro);
    }
}
