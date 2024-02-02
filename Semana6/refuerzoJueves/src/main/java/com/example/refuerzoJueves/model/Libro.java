package com.example.refuerzoJueves.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "libros")
public class Libro {
    @Id
    private String isbn;
    private String titulo;
    @Column(name = "anio_publicacion")
    private Integer anioPublicacion;
    private float precio;
}
