package com.example.springSabado.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class PrestamoId implements Serializable {
    @Column(name = "usuario_id")
    private Integer usuarioId;
    @Column(name = "libro_id")
    private Integer libroId;
}
