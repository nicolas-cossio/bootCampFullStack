package com.example.springBasico.service;

import com.example.springBasico.entity.Producto;
import com.example.springBasico.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Optional<Producto> buscarById(Integer id) {
        return productoRepository.findById(id);
    }

    public Optional<Producto> updateById(Integer id, Producto producto) {
        Optional<Producto> productoBD = productoRepository.findById(id);
        if (productoBD.isPresent()) {
            Producto prodNew = productoBD.get();
            prodNew.setNombre(prodNew.getNombre());
            prodNew.setDescripcion(prodNew.getDescripcion());
            prodNew.setPrecio(prodNew.getPrecio());
            prodNew.setStock(prodNew.getStock());
            prodNew.setCategoria(prodNew.getCategoria());
            return Optional.of(productoRepository.save(prodNew));
        }
        return Optional.empty();
    }
}
