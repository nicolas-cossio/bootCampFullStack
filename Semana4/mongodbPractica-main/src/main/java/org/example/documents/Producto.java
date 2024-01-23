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
    ObjectId idProducto;
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

    public static Producto fromDocument(Document document) {
        Producto producto = new Producto();
        producto.setIdProducto(document.getObjectId("_id"));
        producto.setNombreProducto(document.getString("nombre_producto"));
        producto.setPrecio(document.getDouble("precio"));
        producto.setComentarios(document.getList("comentarios", ObjectId.class));
        return producto;
    }

    public void addComentario(ObjectId idComentario) {
        this.comentarios.add(idComentario);
    }
}