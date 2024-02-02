package com.example.relacionesjpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "notas")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nota_id")
    private Integer id;
    private Integer nota;
    @Column(name = "tipo_evaluacion")
    private String tipoEvaluacion;
    @ManyToOne
    @JoinColumn(name = "curso_id_fk")
    private Curso curso;
    @ManyToOne
    @JoinColumn(name = "estudiante_id_fk")
    private Estudiante estudiante;
    @ManyToOne
    @JoinColumn(name = "profesor_id_fk")
    private Profesor profesor;

}
