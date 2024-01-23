package org.example.documents;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Usuario {
    ObjectId idUsuario;
    String nombre;
    String password;
    List<Producto> productos = new ArrayList<>();
    List<ObjectId> direcciones = new ArrayList<>();

    public Document toDocument() {
        Document document = new Document();
        document.append("nombre", this.getNombre());
        document.append("password", this.getPassword());
//        document.append("productos", this.getProductos());
//        document.append("direcciones", this.getDirecciones());
        return document;
    }

    public static Usuario fromDocument(Document document) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(document.getObjectId("_id"));
        usuario.setNombre(document.getString("nombre"));
        usuario.setPassword(document.getString("password"));
        usuario.setProductos(document.getList("productos", Producto.class));
        usuario.setDirecciones(document.getList("direcciones", ObjectId.class));
        return usuario;
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void agregarDirecciones(ObjectId idDireccion)  {
        direcciones.add(idDireccion);
    }
}
