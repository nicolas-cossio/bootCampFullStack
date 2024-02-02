package com.example.relacionesjpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curso_id")
    private Integer id;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "profesor_id_fk")
    private Profesor profesor;

    // Relacion muchos a muchos con Estudiante
    @ManyToMany(mappedBy = "cursos")
    private List<Estudiante> estudiantes;

}
