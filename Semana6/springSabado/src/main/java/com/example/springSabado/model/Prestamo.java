package com.example.springSabado.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "prestamo")
public class Prestamo {
    @EmbeddedId
    private PrestamoId prestamoId;
    @Column(name = "fecha_prestamo")
    private Date fechaPrestamo;
    @Column(name = "fecha_devolucion")
    private Date fechaDevolucion;
}
