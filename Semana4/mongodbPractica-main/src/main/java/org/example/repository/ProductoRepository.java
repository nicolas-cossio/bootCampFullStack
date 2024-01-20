package org.example.repository;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.example.documents.Producto;

public class ProductoRepository {
    MongoCollection collectionProducto;

    public ProductoRepository(MongoCollection collectionProducto) {
        this.collectionProducto = collectionProducto;
    }

    public void agregarProducto(Producto producto) {
        collectionProducto.insertOne(producto.toDocument());
    }

    public Producto findProducto(String nombreProducto) {
        Document filter = new Document("nombre_producto", nombreProducto);
        Document docProducto = (Document) collectionProducto.find(filter).first();
        Producto producto = new Producto();
        producto.setIdProducto(docProducto.getObjectId("_id").toString());
        producto.setNombreProducto(docProducto.getString("nombre_producto"));
        producto.setPrecio(docProducto.getDouble("precio"));
        return producto;
    }
}
