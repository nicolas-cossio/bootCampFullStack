package org.example.documents;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Usuario {
    String idUsuario;
    String nombre;
    String password;
    List<Producto> productos = new ArrayList<>();
    List<String> direcciones = new ArrayList<>();

    public Document toDocument() {
        Document document = new Document();
        document.append("nombre", this.getNombre());
        document.append("password", this.getPassword());
//        document.append("productos", this.getProductos());
//        document.append("direcciones", this.getDirecciones());
        return document;
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void agregarDirecciones(String idDireccion)  {
        direcciones.add(idDireccion);
    }
}
