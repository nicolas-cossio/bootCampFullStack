package com.example.examenSpring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "avion")
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "avion_id")
    private Integer id;
    private String serie;
    private String modelo;
    @Column(name = "capacidad_pasajeros")
    private Integer capacidadPasajeros;
    private Boolean estado;
    @ManyToOne
    @JoinColumn(name = "aerolinea_id_fk")
    private Aerolinea aerolinea;
}
