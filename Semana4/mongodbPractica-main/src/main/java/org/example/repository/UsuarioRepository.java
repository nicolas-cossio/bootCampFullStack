package org.example.repository;

import com.mongodb.client.MongoCollection;
import org.example.documents.Usuario;

public class UsuarioRepository {
    MongoCollection collectionUsuario;

    public UsuarioRepository(MongoCollection collectionUsuario) {
        this.collectionUsuario = collectionUsuario;
    }

    public void agregarUsuario(Usuario usuario) {
        collectionUsuario.insertOne(usuario.toDocument());
    }

}
