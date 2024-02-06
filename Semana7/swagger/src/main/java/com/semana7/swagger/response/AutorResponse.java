package com.semana7.swagger.response;

import com.semana7.swagger.model.Autor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorResponse {
    private Integer id;
    private String tipoDoc;
    private String numDoc;
    private String nombres;
    private String apellidos;
    private String email;

    public AutorResponse(Autor autor) {
        this.id = autor.getId();
        this.tipoDoc = autor.getTipoDoc();
        this.numDoc = autor.getNumDoc();
        this.nombres = autor.getNombres();
        this.apellidos = autor.getApellidos();
        this.email = autor.getEmail();
    }

}
