package com.semana7.swagger.model;

import com.semana7.swagger.request.AutorRequest;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor")
    private Integer id;
    @Column(name = "tipo_doc")
    private String tipoDoc;
    @Column(name = "num_doc")
    private String numDoc;
    private String nombres;
    private String apellidos;
    private String email;
    private Integer estado;
    @Column(name = "user_create")
    private String userCreate;
    private Timestamp dateCreate;
    @Column(name = "user_modif")
    private String userModif;
    private Timestamp dateModif;
    @Column(name = "user_delete")
    private String userDelete;
    private Timestamp dateDelete;


    public Autor reqToModel(AutorRequest autorReq) {
        Autor autor = new Autor();
        autor.setNombres(autorReq.getNombres());
        autor.setApellidos(autorReq.getApellidos());
        autor.setTipoDoc(autorReq.getTipoDoc());
        autor.setNumDoc(autorReq.getNumDoc());
        autor.setEmail(autorReq.getEmail());
        return autor;
    }

}
