package com.semana7.swagger.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class AutorRequest {
    private String tipoDoc;
    private String numDoc;
    private String nombres;
    private String apellidos;
    private String email;
}
