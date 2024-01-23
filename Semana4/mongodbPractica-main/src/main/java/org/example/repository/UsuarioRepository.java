package org.example.repository;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.example.documents.Usuario;

public class UsuarioRepository {
    MongoCollection collectionUsuario;

    public UsuarioRepository(MongoCollection collectionUsuario) {
        this.collectionUsuario = collectionUsuario;
    }

    public void save(Usuario usuario) {
        collectionUsuario.insertOne(usuario.toDocument());
    }

    public Usuario findUsuarioByNombre(String nombreUsuario) {
        Document filter = new Document("nombre", nombreUsuario);
        Document usuarioDB = (Document) collectionUsuario.find(filter).first();
        if (usuarioDB != null) {
            return Usuario.fromDocument(usuarioDB);
        }
        // Por temas de simplicidad, si no encuentra el usuario, regresamos un usuario vacio
        // pero deberiamos enviar un response o algo parecido.
        return new Usuario();
    }

}
