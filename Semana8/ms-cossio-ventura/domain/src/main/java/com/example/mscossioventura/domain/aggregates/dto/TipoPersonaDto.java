package com.example.mscossioventura.domain.aggregates.dto;

import java.sql.Timestamp;

public class TipoPersonaDto {
    private Long idTipoPersona;
    private String codTipo;
    private String descTipo;
    private Integer estado;
    private String usuaCrea;
    private Timestamp dateCreate;
    private String usuaModif;
    private Timestamp dateModif;
    private String usuaDelet;
    private Timestamp dateDelet;
}
