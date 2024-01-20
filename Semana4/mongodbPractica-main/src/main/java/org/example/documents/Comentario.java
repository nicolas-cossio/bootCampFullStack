package org.example.documents;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

@Getter
@Setter
public class Comentario {
    String idComentario;
    String contenido;

    public Document toDocument() {
        Document document = new Document();
        document.append("contenido", this.getContenido());
        return document;
    }
}