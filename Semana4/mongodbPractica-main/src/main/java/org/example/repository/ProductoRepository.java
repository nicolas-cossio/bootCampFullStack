package org.example.repository;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.example.documents.Producto;

public class ProductoRepository {
    MongoCollection collectionProducto;

    public ProductoRepository(MongoCollection collectionProducto) {
        this.collectionProducto = collectionProducto;
    }

    public void save(Producto producto) {
        collectionProducto.insertOne(producto.toDocument());
    }

    public Producto findProductoByNombre(String nombreProducto) {
        Document filter = new Document("nombre_producto", nombreProducto);
        Document productoDB = (Document) collectionProducto.find(filter).first();
        if (productoDB != null) {
            return Producto.fromDocument(productoDB);
        }
        // Por temas de simplicidad, si no encuentra el producto, regresamos un producto vacio
        // pero deberiamos enviar un response o algo parecido.
        return new Producto();
    }
}
