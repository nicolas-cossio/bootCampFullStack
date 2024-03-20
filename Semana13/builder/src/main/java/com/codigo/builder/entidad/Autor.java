package com.codigo.builder.entidad;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Autor {
    private String nombre;
    private String apellido;
}
