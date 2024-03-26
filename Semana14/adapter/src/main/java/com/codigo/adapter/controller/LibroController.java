package com.codigo.adapter.controller;

import com.codigo.adapter.adapter.AdapterBiblioteca;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/patron/adapter")
@RequiredArgsConstructor
public class LibroController {
    private final AdapterBiblioteca adapterBiblioteca;

    @GetMapping("/libro/{id}")
    public String obtenerDetallesLibro(@PathVariable int id) {
        return adapterBiblioteca.obtenerDetallesLibroJson(id);
    }

}
