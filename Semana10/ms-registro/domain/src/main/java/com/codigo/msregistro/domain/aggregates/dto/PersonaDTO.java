package com.codigo.msregistro.domain.aggregates.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {
    private Long idPersona;
    private String numDocu;
    private String nombres;
    private String apePat;
    private String apeMat;
    private Integer estado;
    private String usuaCrea;
    private Timestamp dateCreate;
    private String usuaModif;
    private Timestamp dateModif;
    private String usuaDelet;
    private Timestamp dateDelet;

    public PersonaDTO(Long idPersona, String numDocu, String nombres, String apePat, String apeMat, Integer estado) {
        this.idPersona = idPersona;
        this.numDocu = numDocu;
        this.nombres = nombres;
        this.apePat = apePat;
        this.apeMat = apeMat;
        this.estado = estado;
    }
}
