package org.example.service;

import com.mongodb.client.MongoCollection;
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
            Usuario usuarioDB = usuarioRepository.findUsuarioByNombre(usuario.getNombre());
            if (usuarioDB.getNombre() != null) {
                throw new Exception("El usuario ya existe");
            }
            //Verificamos que le nombre tenga al menos tres caracteres
            if (usuario.getNombre().length() < 3) {
                throw new Exception("El nombre debe tener al menos tres caracteres");
            }
            usuarioRepository.save(usuario);
            System.out.println("Usuario agregado exitosamente.");
        } catch (Exception e) {
            // Logica de manejo de errores
            System.out.println("ERROR: "+e.getMessage());
        }
    }

    public void agregarProducto(String nombreProducto) {
        MongoCollection productoCollection = MongoDBConnector.database.getCollection("productos");
        ProductoRepository productoRepository = new ProductoRepository(productoCollection);
        Producto producto = productoRepository.findProductoByNombre(nombreProducto);
        System.out.println(producto.getNombreProducto());
    }

}
