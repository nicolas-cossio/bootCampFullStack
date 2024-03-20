package com.codigo.builder.controller;


import com.codigo.builder.entidad.Autor;
import com.codigo.builder.entidad.Libro;
import com.codigo.builder.entidad.Libro2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1/patron/builder")
public class LibroController {

    @GetMapping
    public Libro obtenerLibro() {
        return new Libro.Builder()
                .titulo("El señor de los anillos")
                .autor("J.R.R. Tolkien")
                .isbn("978-84-450-7423-8")
                .fechaPublicacion(LocalDate.parse("1954-07-29"))
                .build();
    }

    @GetMapping("/libroNuevo")
    public Libro2 obtenerLibroNuevo() {
        return Libro2.builder()
                .titulo("El poder del ahora")
                .autor(Autor.builder().nombre("Eckhart").apellido("Tolle").build())
                .isbn("XXX-XX-XXXX-XX-X")
                .fechaPublicacion(LocalDate.parse("1954-07-29"))
                .build();
    }
}
