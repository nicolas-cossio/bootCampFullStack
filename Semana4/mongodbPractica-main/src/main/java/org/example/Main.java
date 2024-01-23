package org.example;

import com.mongodb.client.MongoCollection;
import org.example.db.MongoDBConnector;
import org.example.documents.Comentario;
import org.example.documents.Producto;
import org.example.documents.Usuario;
import org.example.repository.ComentarioRepository;
import org.example.repository.ProductoRepository;
import org.example.repository.UsuarioRepository;
import org.example.service.ComentarioService;
import org.example.service.ProductoService;
import org.example.service.UsuarioService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MongoDBConnector.connect();
        List<String> collections = MongoDBConnector.database.listCollectionNames().into(new ArrayList<>());
        MongoCollection comentarioCollection = MongoDBConnector.database.getCollection("comentarios");
        MongoCollection productoCollection = MongoDBConnector.database.getCollection("productos");
        MongoCollection usuarioCollection = MongoDBConnector.database.getCollection("usuarios");

        ComentarioRepository comentarioRepository = new ComentarioRepository(comentarioCollection);
        ProductoRepository productoRepository = new ProductoRepository(productoCollection);
        UsuarioRepository usuarioRepository = new UsuarioRepository(usuarioCollection);

//        ComentarioService comentarioService = new ComentarioService(comentarioRepository);
//        Comentario comentario = new Comentario();
//        comentario.setContenido("Excelente producto");
//        String id = comentarioService.agregarComentario(comentario);
//        System.out.println(id);

//        ProductoService productoService = new ProductoService(productoRepository);
//        Producto producto = new Producto();
//        producto.setNombreProducto("Laptop ASUS");
//        producto.setPrecio(999.99);
//        producto.agregarComentario(id);
//        productoService.agregarProducto(producto);

        UsuarioService usuarioService = new UsuarioService(usuarioRepository);
//        usuarioService.agregarProducto("Laptop HP");
        Usuario usuario = new Usuario();
        usuario.setNombre("Jose");
        usuario.setPassword("1234");
        usuario.setProductos(new ArrayList<>());
        usuario.setDirecciones(new ArrayList<>());
        usuarioService.agregarUsuario(usuario);

    }
}