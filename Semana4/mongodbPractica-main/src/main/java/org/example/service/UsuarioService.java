package org.example.service;

import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;
import org.example.db.MongoDBConnector;
import org.example.documents.Producto;
import org.example.documents.Usuario;
import org.example.repository.ProductoRepository;
import org.example.repository.UsuarioRepository;

public class UsuarioService {
    UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void agregarUsuario(Usuario usuario) {
        // Logica de negocio
        try {
            // Verificamos el usuario no exista

            //Verificamos que le nombre tenga al menos tres caracteres
            usuarioRepository.agregarUsuario(usuario);
        } catch (Exception e) {
            // Logica de manejo de errores
            System.out.println(e.getMessage());
        }
    }

    public void agregarProducto(String nombreProducto) {
        MongoCollection productoCollection = MongoDBConnector.database.getCollection("productos");
        ProductoRepository productoRepository = new ProductoRepository(productoCollection);
        Producto producto = productoRepository.findProducto(nombreProducto);
        System.out.println(producto.getNombreProducto());
    }

}
