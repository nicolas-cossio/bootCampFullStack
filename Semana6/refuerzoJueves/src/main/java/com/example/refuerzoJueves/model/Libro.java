package com.example.refuerzoJueves.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    // Relacion con tabla editorial.
    @ManyToOne
    @JoinColumn(name = "editorial_id_fk")
    private Editorial editorial;

    // Relacion con tabla comentarios.
    @OneToMany
    @JoinColumn(name = "isbn")
    private List<Comentario> comentarios;
}
