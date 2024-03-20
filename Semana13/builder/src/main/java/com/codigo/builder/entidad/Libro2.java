package com.codigo.builder.entidad;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Builder
public class Libro2 {
    private String titulo;
    private Autor autor;
    private String isbn;
    private LocalDate fechaPublicacion;
//    private Set<Autor> autores;
}
