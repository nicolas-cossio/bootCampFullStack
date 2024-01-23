package org.example.documents;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.bson.types.ObjectId;

@Getter
@Setter
public class Comentario {
    ObjectId idComentario;
    String contenido;

    public Document toDocument() {
        Document document = new Document();
        document.append("contenido", this.getContenido());
        return document;
    }

    public static Comentario fromDocument(Document document) {
        Comentario comentario = new Comentario();
        comentario.setIdComentario(document.getObjectId("_id"));
        comentario.setContenido(document.getString("contenido"));
        return comentario;
    }
}