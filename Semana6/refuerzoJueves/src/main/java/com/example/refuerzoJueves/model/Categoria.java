package com.example.refuerzoJueves.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    private Integer id;
    private String nombre;
    @ManyToMany
    @JoinTable( name = "libros_categorias",
            joinColumns = @JoinColumn(name = "categoria_id_fk"),
            inverseJoinColumns = @JoinColumn(name = "isbn")
    )
    private List<Libro> libros;
}
