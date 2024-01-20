package org.example.documents;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Producto {
    String idProducto;
    String nombreProducto;
    Double precio;
    List<ObjectId> comentarios = new ArrayList<>();

    public void agregarComentario(String idComentario) {
        ObjectId id = new ObjectId(idComentario);
        this.comentarios.add(id);
    }

    public Document toDocument() {
        Document document = new Document();
        document.append("nombre_producto", this.getNombreProducto());
        document.append("precio", this.getPrecio());
        document.append("comentarios", this.getComentarios());
        return document;
    }
}