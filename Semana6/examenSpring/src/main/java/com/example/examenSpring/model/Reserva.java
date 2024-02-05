package com.example.examenSpring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserva_id")
    private Integer id;
    private String codigoReserva;
    @Column(name = "asiento_numero")
    private Integer asientoNumero;
    private Boolean estado;
    @ManyToOne
    @JoinColumn(name = "vuelo_id_fk")
    private Vuelo vuelo;
    @ManyToOne
    @JoinColumn(name = "pasajero_id_fk")
    private Pasajero pasajero;

}
