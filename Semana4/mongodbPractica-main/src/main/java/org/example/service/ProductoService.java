package org.example.service;

import org.example.documents.Producto;
import org.example.repository.ProductoRepository;

public class ProductoService {
    ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public void agregarProducto(Producto producto) {
        // Logica de negocio
        try {
            productoRepository.agregarProducto(producto);
        } catch (Exception e) {
            // Logica de manejo de errores
            System.out.println(e.getMessage());
        }
    }
}
