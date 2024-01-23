package org.example.repository;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.example.documents.Comentario;

public class ComentarioRepository {
    MongoCollection collectionComentario;

    public ComentarioRepository(MongoCollection collectionComentario) {
        this.collectionComentario = collectionComentario;
    }

    public String save(Comentario comentario) {
        Document documentComentario = comentario.toDocument();
        collectionComentario.insertOne(documentComentario);
        ObjectId idComentario = documentComentario.getObjectId("_id");
        return idComentario.toString();
    }
}
